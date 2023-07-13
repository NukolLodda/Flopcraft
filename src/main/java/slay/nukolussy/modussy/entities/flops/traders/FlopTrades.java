package slay.nukolussy.modussy.entities.flops.traders;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import slay.nukolussy.modussy.item.ModItem;

import javax.annotation.Nullable;
import java.util.Map;

public class FlopTrades {
    private static final int DEFAULT_SUPPLY = 36;
    private static final int COMMON_ITEMS_SUPPLY = 69;
    private static final int UNCOMMON_ITEMS_SUPPLY = 12;

    public static final Map<FlopTraderVariants, Int2ObjectMap<FlopTrades.ItemListing[]>> TRADES =
            Util.make(Maps.newHashMap(), (tag) -> {
                tag.put(JiafeiVariant.AESTHETIC, toIntMap(ImmutableMap.of(1, new FlopTrades.ItemListing[]{
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_PERFUME.get(), 9, UNCOMMON_ITEMS_SUPPLY, 6),
                        new FlopTrades.ProductsForSlaginium(ModItem.JIAFEI_PRODUCT.get(), COMMON_ITEMS_SUPPLY, 1),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_BOOTS.get(), 8, DEFAULT_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_LEGGINGS.get(), 11, DEFAULT_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_CHESTPLATE.get(), 10, DEFAULT_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_HELMET.get(), 9, DEFAULT_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.DEELDO.get(), 7, UNCOMMON_ITEMS_SUPPLY, 6)
                })));
                tag.put(JiafeiVariant.MUSICIAN, toIntMap(ImmutableMap.of(1, new FlopTrades.ItemListing[]{
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI.get(), 6, DEFAULT_SUPPLY, 2),
                        new FlopTrades.ProductsForSlaginium(ModItem.JIAFEI_PRODUCT.get(), COMMON_ITEMS_SUPPLY, 1),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_REMIX.get(), 7, DEFAULT_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.BAD_ROMANCE.get(), 7, UNCOMMON_ITEMS_SUPPLY, 6),
                        new FlopTrades.SlaginiumForProducts(ModItem.DRIVERS.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6),
                        new FlopTrades.SlaginiumForProducts(ModItem.NEED_DOCTOR.get(), 4, DEFAULT_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.RESONANCE.get(), 10, UNCOMMON_ITEMS_SUPPLY, 12)
                })));
                tag.put(JiafeiVariant.UTILITIES, toIntMap(ImmutableMap.of(1, new FlopTrades.ItemListing[]{
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_SEED.get(), 4, UNCOMMON_ITEMS_SUPPLY, 6),
                        new FlopTrades.ProductsForSlaginium(ModItem.JIAFEI_PRODUCT.get(), COMMON_ITEMS_SUPPLY, 1),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_AXE.get(), 4, DEFAULT_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_SHOVEL.get(), 2,DEFAULT_SUPPLY,2),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_PICKAXE.get(), 4, DEFAULT_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_HAMMER.get(), 6, DEFAULT_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_SICKLE.get(), 5, DEFAULT_SUPPLY, 2)
                })));
            });

    private static Int2ObjectMap<FlopTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, FlopTrades.ItemListing[]> pMap) {
        return new Int2ObjectOpenHashMap<>(pMap);
    }

    public interface ItemListing {
        @Nullable
        MerchantOffer getOffer(Entity pTrader, RandomSource pRandom);
    }

    static class ProductsForSlaginium implements ItemListing {
        private final Item item;
        private final int maxUses;
        private final int flopXp;
        private final float priceMultiplier;

        public ProductsForSlaginium(ItemLike pItem, int pMaxUses, int pFlopXp) {
            this.item = pItem.asItem();
            this.maxUses = pMaxUses;
            this.flopXp = pFlopXp;
            this.priceMultiplier = 0.05F;
        }

        public MerchantOffer getOffer(Entity pTrader, RandomSource pRandom) {
            ItemStack itemstack = new ItemStack(this.item, 5);
            return new MerchantOffer(itemstack, new ItemStack(ModItem.SLAGINIUM.get(), 12), this.maxUses, this.flopXp, this.priceMultiplier);
        }
    }
    static class SlaginiumForProducts implements ItemListing {
        private final Item item;
        private final int cost;
        private final int maxUses;
        private final int flopXp;
        private final float priceMultiplier;

        public SlaginiumForProducts(ItemLike pItem, int pCost, int pMaxUses, int pFlopXp) {
            this.item = pItem.asItem();
            this.cost = pCost;
            this.maxUses = pMaxUses;
            this.flopXp = pFlopXp;
            this.priceMultiplier = 0.05F;
        }

        public MerchantOffer getOffer(Entity pTrader, RandomSource pRandom) {
            ItemStack itemstack = new ItemStack(this.item);
            return new MerchantOffer(new ItemStack(ModItem.SLAGINIUM.get(), this.cost), itemstack, this.maxUses, this.flopXp, this.priceMultiplier);
        }
    }
}
