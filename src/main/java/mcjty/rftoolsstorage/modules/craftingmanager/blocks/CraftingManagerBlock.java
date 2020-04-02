package mcjty.rftoolsstorage.modules.craftingmanager.blocks;

import mcjty.lib.blocks.BaseBlock;
import mcjty.lib.blocks.RotationType;
import mcjty.lib.builder.BlockBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import static mcjty.lib.builder.TooltipBuilder.*;


public class CraftingManagerBlock extends BaseBlock {

    private static final Block.Properties STANDARD_GLASS = Block.Properties.create(Material.GLASS)
            .hardnessAndResistance(2.0f)
            .sound(SoundType.GLASS);


    public CraftingManagerBlock() {
        super(new BlockBuilder()
                .properties(STANDARD_GLASS)
                .info(key("message.rftoolsstorage.shiftmessage"))
                .infoShift(header(), gold())
                .tileEntitySupplier(CraftingManagerTileEntity::new)
        );
    }

    @Override
    public RotationType getRotationType() {
        return RotationType.NONE;
    }

    // @todo temporary
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
    }

    @Override
    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
        if (side == Direction.UP || side == Direction.DOWN) {
            return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
        }
        return false;
    }
}
