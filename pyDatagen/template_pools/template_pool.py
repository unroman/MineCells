import os

ELEMENT_TEMPLATE = """    {
      "weight": {{weight}},
      "element": {
        "element_type": "minecraft:single_pool_element",
        "location": "{{name}}",
        "projection": "rigid",
        "processors": "{{processors}}"
      }
    },
"""

TEMPLATE = """{
  "name": "{{name}}",
  "fallback": "minecraft:empty",
  "elements": [
{{elements}}
  ]
}
"""


def generate_template_pool(elements: [(str, int)], name: str, processors: str):
    result = ""
    for element in elements:
        result += ELEMENT_TEMPLATE.replace("{{name}}", element[0]).replace("{{weight}}", str(element[1]))

    result = result[:-2]
    return TEMPLATE.replace("{{elements}}", result).replace("{{name}}", name).replace("{{processors}}", processors)


class TemplatePoolGenerator:
    def __init__(self, output_path: str):
        self.output_path = output_path

    def generate_prefixed(self, file_name: str, elements: [(str, int)], prefix: str, processors: str = "minecraft:empty"):
        prefixed_elements = []
        for e in elements:
            if ":" in e[0]:
                prefixed_elements.append(e)
            else:
                prefixed_elements.append((prefix + "/" + e[0], e[1]))
        self.save_to_file(file_name, generate_template_pool(prefixed_elements, file_name, processors))

    def generate_autoprefixed(self, file_name: str, elements: [(str, int)], processors: str = "minecraft:empty"):
        self.generate_prefixed(file_name, elements, file_name, processors)

    def generate(self, file_name: str, elements: [(str, int)], processors: str = "minecraft:empty"):
        self.save_to_file(file_name, generate_template_pool(elements, file_name, processors))

    def generate_single(self, file_name: str, processors: str = "minecraft:empty"):
        self.generate(file_name, [(file_name, 1)], processors)

    def save_to_file(self, file_name: str, template: str):
        file_name = file_name.split(":")[-1]
        output = os.path.join(self.output_path, file_name + ".json")
        os.makedirs(os.path.dirname(output), exist_ok=True)
        with open(self.output_path + "\\" + file_name + ".json", "w") as file:
            file.write(template)