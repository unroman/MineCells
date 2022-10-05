package com.github.mim1q.minecells.structure;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureType;

import java.util.Optional;

public class BigDungeonStructure extends Structure {
  public static Codec<BigDungeonStructure> CODEC = RecordCodecBuilder.<BigDungeonStructure>mapCodec((instance) ->
    instance
      .group(
        BigDungeonStructure.configCodecBuilder(instance),
        StructurePool.REGISTRY_CODEC.fieldOf("start_pool").forGetter((structure) -> structure.startPool),
        Identifier.CODEC.optionalFieldOf("start_jigsaw_name").forGetter((structure) -> structure.startJigsawName),
        Codec.intRange(0, 100).fieldOf("size").forGetter((structure) -> structure.size),
        Codec.intRange(-64, 320).fieldOf("y").forGetter((structure) -> structure.y),
        Codec.intRange(1, 1024).fieldOf("max_distance_from_center").forGetter((structure) -> structure.maxDistanceFromCenter)
      )
      .apply(instance, BigDungeonStructure::new)).codec();

  private final RegistryEntry<StructurePool> startPool;
  private final Optional<Identifier> startJigsawName;
  private final int size;
  private final int y;
  private final int maxDistanceFromCenter;

  protected BigDungeonStructure(
    Config config,
    RegistryEntry<StructurePool> startPool,
    Optional<Identifier> startJigsawName,
    int size,
    int y,
    int maxDistanceFromCenter
  ) {
    super(config);
    this.startPool = startPool;
    this.startJigsawName = startJigsawName;
    this.size = size;
    this.y = y;
    this.maxDistanceFromCenter = maxDistanceFromCenter;
  }

  private static boolean extraSpawnConditions(Structure.Context context) {
    ChunkPos chunkPos = context.chunkPos();
    return chunkPos.x % 64 == 0 && chunkPos.z % 64 == 0;
  }

  @Override
  public Optional<StructurePosition> getStructurePosition(Context context) {
    if (!extraSpawnConditions(context)) {
      return Optional.empty();
    }

    ChunkPos chunkPos = context.chunkPos();
    BlockPos pos = new BlockPos(chunkPos.getStartX(), this.y, chunkPos.getStartZ());

    return StructurePoolBasedGenerator.generate(
      context,
      this.startPool,
      this.startJigsawName,
      this.size,
      pos,
      false,
      Optional.empty(),
      this.maxDistanceFromCenter
    );
  }

  @Override
  public StructureType<?> getType() {
    return MineCellsStructures.BIG_DUNGEON;
  }
}