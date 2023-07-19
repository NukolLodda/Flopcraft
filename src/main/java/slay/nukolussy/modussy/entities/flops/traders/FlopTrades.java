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
                tag.put(Jiafei.Variant.AESTHETIC, toIntMap(ImmutableMap.of(1, new FlopTrades.ItemListing[]{
                        new FlopTrades.ProductsForSlaginium(ModItem.JIAFEI_PRODUCT.get(), COMMON_ITEMS_SUPPLY, 1),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_HELMET.get(), 4, DEFAULT_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_CHESTPLATE.get(), 5, DEFAULT_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_LEGGINGS.get(), 5, DEFAULT_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_BOOTS.get(), 4, DEFAULT_SUPPLY, 2),
                        new FlopTrades.InfusedSlaginiumForProducts(ModItem.JIAFEI_PERFUME.get(), 4, UNCOMMON_ITEMS_SUPPLY, 6),
                        new FlopTrades.InfusedSlaginiumForProducts(ModItem.DEELDO.get(), 3, UNCOMMON_ITEMS_SUPPLY, 6) // temporary. will be replaced with jiafei jetpacks
                })));
                tag.put(Jiafei.Variant.MUSICIAN, toIntMap(ImmutableMap.of(1, new FlopTrades.ItemListing[]{
                        new FlopTrades.ProductsForSlaginium(ModItem.JIAFEI_PRODUCT.get(), COMMON_ITEMS_SUPPLY, 1),
                        new FlopTrades.SlaginiumForProducts(ModItem.DISC_CJ1.get(), 2, DEFAULT_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.DISC_JIAFEI.get(), 3, DEFAULT_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.DISC_J1.get(), 3, UNCOMMON_ITEMS_SUPPLY, 6),
                        new FlopTrades.SlaginiumForProducts(ModItem.DISC_J2.get(), 3, UNCOMMON_ITEMS_SUPPLY, 6),
                        new FlopTrades.InfusedSlaginiumForProducts(ModItem.DISC_J4.get(), 3, DEFAULT_SUPPLY, 2),
                        new FlopTrades.InfusedSlaginiumForProducts(ModItem.DISC_J5.get(), 5, UNCOMMON_ITEMS_SUPPLY, 12)
                })));
                tag.put(Jiafei.Variant.UTILITIES, toIntMap(ImmutableMap.of(1, new FlopTrades.ItemListing[]{
                        new FlopTrades.ProductsForSlaginium(ModItem.JIAFEI_PRODUCT.get(), COMMON_ITEMS_SUPPLY, 1),
                        new FlopTrades.SlaginiumForProducts(ModItem.CVM.get(), 2, UNCOMMON_ITEMS_SUPPLY, 6),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_AXE.get(), 2, DEFAULT_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_SHOVEL.get(), 1,DEFAULT_SUPPLY,2),
                        new FlopTrades.SlaginiumForProducts(ModItem.JIAFEI_PICKAXE.get(), 2, DEFAULT_SUPPLY, 2),
                        new FlopTrades.InfusedSlaginiumForProducts(ModItem.JIAFEI_HAMMER.get(), 3, DEFAULT_SUPPLY, 2),
                        new FlopTrades.InfusedSlaginiumForProducts(ModItem.JIAFEI_SICKLE.get(), 2, DEFAULT_SUPPLY, 2)
                })));
                tag.put(NickiMinaj.Variant.VARIANT, toIntMap(ImmutableMap.of(1, new FlopTrades.ItemListing[]{
                        new FlopTrades.ProductsForSlaginium(ModItem.HAIRUSSY.get(), COMMON_ITEMS_SUPPLY, 1),
                        new FlopTrades.SlaginiumForProducts(ModItem.BRA.get(), 2, COMMON_ITEMS_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.DISC_C16.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.DISC_C23.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new FlopTrades.SlaginiumForProducts(ModItem.DISC_C26.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new FlopTrades.InfusedSlaginiumForProducts(ModItem.DISC_JC2.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6),
                        new FlopTrades.InfusedSlaginiumForProducts(ModItem.DEELDO.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6)
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
    static class InfusedSlaginiumForProducts implements ItemListing {
        private final Item item;
        private final int cost;
        private final int maxUses;
        private final int flopXp;
        private final float priceMultiplier;

        public InfusedSlaginiumForProducts(ItemLike pItem, int pCost, int pMaxUses, int pFlopXp) {
            this.item = pItem.asItem();
            this.cost = pCost;
            this.maxUses = pMaxUses;
            this.flopXp = pFlopXp;
            this.priceMultiplier = 0.05F;
        }

        public MerchantOffer getOffer(Entity pTrader, RandomSource pRandom) {
            ItemStack itemstack = new ItemStack(this.item);
            return new MerchantOffer(new ItemStack(ModItem.INFUSED_SLAGINIUM.get(), this.cost), itemstack, this.maxUses, this.flopXp, this.priceMultiplier);
        }
    }
}
