package net.nukollodda.flopcraft.entities.flops.traders;

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
import net.nukollodda.flopcraft.item.FlopItems;

import javax.annotation.Nullable;
import java.util.Map;

public class FlopTrades {
    private static final int DEFAULT_SUPPLY = 36;
    private static final int COMMON_ITEMS_SUPPLY = 69;
    private static final int UNCOMMON_ITEMS_SUPPLY = 12;

    public static final Map<IFlopTraderVariant, Int2ObjectMap<ItemListing[]>> TRADES =
            Util.make(Maps.newHashMap(), (tag) -> {
                tag.put(CharliXCX.Variant.VARIANT, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForBrat(FlopItems.SLAGINIUM.get(), COMMON_ITEMS_SUPPLY, 1),
                        new BratForProducts(FlopItems.KAMALOCONUT.get(), 2, DEFAULT_SUPPLY, 2),
                        new BratForProducts(FlopItems.SLAGINIUM_YASSIFIER.get(), 3, UNCOMMON_ITEMS_SUPPLY, 6),
                        new BratForProducts(FlopItems.DISC_C30.get(), 5, DEFAULT_SUPPLY, 2),
                        new BratForProducts(FlopItems.DISC_C31.get(), 5, DEFAULT_SUPPLY, 2),
                        new BratForProducts(FlopItems.DISC_C32.get(), 5, DEFAULT_SUPPLY, 2),
                        new BratForProducts(FlopItems.DISC_J7.get(), 5, UNCOMMON_ITEMS_SUPPLY, 6)
                })));
                tag.put(Jiafei.Variant.AESTHETIC, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForSlaginium(FlopItems.JIAFEI_PRODUCT.get(), COMMON_ITEMS_SUPPLY, 1),
                        new SlaginiumForProducts(FlopItems.JIAFEI_HELMET.get(), 4, DEFAULT_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.JIAFEI_CHESTPLATE.get(), 5, DEFAULT_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.JIAFEI_LEGGINGS.get(), 5, DEFAULT_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.JIAFEI_BOOTS.get(), 4, DEFAULT_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(FlopItems.JIAFEI_PERFUME.get(), 4, UNCOMMON_ITEMS_SUPPLY, 6),
                        new InfusedSlaginiumForProducts(FlopItems.DEELDO.get(), 3, UNCOMMON_ITEMS_SUPPLY, 6) // temporary. will be replaced with jiafei jetpacks
                })));
                tag.put(Jiafei.Variant.MUSICIAN, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForSlaginium(FlopItems.JIAFEI_PRODUCT.get(), COMMON_ITEMS_SUPPLY, 1),
                        new SlaginiumForProducts(FlopItems.DISC_CJ1.get(), 2, DEFAULT_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_JIAFEI.get(), 3, DEFAULT_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_J1.get(), 3, UNCOMMON_ITEMS_SUPPLY, 6),
                        new SlaginiumForProducts(FlopItems.DISC_J2.get(), 3, UNCOMMON_ITEMS_SUPPLY, 6),
                        new InfusedSlaginiumForProducts(FlopItems.DISC_J4.get(), 3, DEFAULT_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(FlopItems.DISC_J5.get(), 5, UNCOMMON_ITEMS_SUPPLY, 12)
                })));
                tag.put(Jiafei.Variant.UTILITIES, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForSlaginium(FlopItems.JIAFEI_PRODUCT.get(), COMMON_ITEMS_SUPPLY, 1),
                        new SlaginiumForProducts(FlopItems.CVM.get(), 2, UNCOMMON_ITEMS_SUPPLY, 6),
                        new SlaginiumForProducts(FlopItems.JIAFEI_AXE.get(), 2, DEFAULT_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.JIAFEI_SHOVEL.get(), 1,DEFAULT_SUPPLY,2),
                        new SlaginiumForProducts(FlopItems.JIAFEI_PICKAXE.get(), 2, DEFAULT_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(FlopItems.JIAFEI_HAMMER.get(), 3, DEFAULT_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(FlopItems.JIAFEI_SICKLE.get(), 2, DEFAULT_SUPPLY, 2)
                })));
                tag.put(NickiMinaj.Variant.VARIANT, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForSlaginium(FlopItems.HAIRUSSY.get(), COMMON_ITEMS_SUPPLY, 1),
                        new SlaginiumForProducts(FlopItems.BRA.get(), 2, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_C16.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_C23.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_C26.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(FlopItems.DISC_JC2.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6),
                        new InfusedSlaginiumForProducts(FlopItems.ROSETOY.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6)
                })));
                tag.put(Ranvision.Variant.KPOP, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForSlaginium(FlopItems.JIAFEI_PRODUCT.get(), COMMON_ITEMS_SUPPLY, 1),
                        new SlaginiumForProducts(FlopItems.DISC_C1.get(), 2, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_C5.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_C10.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_C14.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(FlopItems.DISC_CPM1.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6),
                        new InfusedSlaginiumForProducts(FlopItems.WONYOUNG_ESSENCE.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6)
                })));
                tag.put(Ranvision.Variant.CULTURAL, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForSlaginium(FlopItems.CUPCAKE.get(), COMMON_ITEMS_SUPPLY, 1),
                        new SlaginiumForProducts(FlopItems.DISC_C4.get(), 2, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_C8.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_C11.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_C17.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(FlopItems.DISC_C18.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6),
                        new InfusedSlaginiumForProducts(FlopItems.CVMTITPLASM.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6)
                })));
                tag.put(Ranvision.Variant.POP, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForSlaginium(FlopItems.ARANA_GRANDE.get(), COMMON_ITEMS_SUPPLY, 1),
                        new SlaginiumForProducts(FlopItems.DISC_C6.get(), 2, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_C7.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_C9.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_CJ1.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(FlopItems.DISC_J3.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6),
                        new InfusedSlaginiumForProducts(FlopItems.SLAGINIUM_YASSIFIER_PREMIUM.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6)
                })));
                tag.put(Ranvision.Variant.EVENT, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForSlaginium(FlopItems.CVMTITPLASM.get(), COMMON_ITEMS_SUPPLY, 1),
                        new SlaginiumForProducts(FlopItems.DISC_C23.get(), 2, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_C24.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_J5.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(FlopItems.DISC_PM1.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(FlopItems.DISC_C28.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6),
                        new InfusedSlaginiumForProducts(FlopItems.KYLIE_JENNER_LIPSTICK.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6)
                })));
            });

    private static Int2ObjectMap<ItemListing[]> toIntMap(ImmutableMap<Integer, ItemListing[]> pMap) {
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
            return new MerchantOffer(itemstack, new ItemStack(FlopItems.SLAGINIUM.get(), 12), this.maxUses, this.flopXp, this.priceMultiplier);
        }
    }
    static class ProductsForBrat implements ItemListing {
        private final Item item;
        private final int maxUses;
        private final int flopXp;
        private final float priceMultiplier;

        public ProductsForBrat(ItemLike pItem, int pMaxUses, int pFlopXp) {
            this.item = pItem.asItem();
            this.maxUses = pMaxUses;
            this.flopXp = pFlopXp;
            this.priceMultiplier = 0.05F;
        }

        public MerchantOffer getOffer(Entity pTrader, RandomSource pRandom) {
            ItemStack itemstack = new ItemStack(this.item, 5);
            return new MerchantOffer(itemstack, new ItemStack(FlopItems.BRAT.get(), 12), this.maxUses, this.flopXp, this.priceMultiplier);
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
            return new MerchantOffer(new ItemStack(FlopItems.SLAGINIUM.get(), this.cost), itemstack, this.maxUses, this.flopXp, this.priceMultiplier);
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
            return new MerchantOffer(new ItemStack(FlopItems.INFUSED_SLAGINIUM.get(), this.cost), itemstack, this.maxUses, this.flopXp, this.priceMultiplier);
        }
    }

    static class BratForProducts implements ItemListing {
        private final Item item;
        private final int cost;
        private final int maxUses;
        private final int flopXp;
        private final float priceMultiplier;

        public BratForProducts(ItemLike pItem, int pCost, int pMaxUses, int pFlopXp) {
            this.item = pItem.asItem();
            this.cost = pCost;
            this.maxUses = pMaxUses;
            this.flopXp = pFlopXp;
            this.priceMultiplier = 0.05F;
        }

        public MerchantOffer getOffer(Entity pTrader, RandomSource pRandom) {
            ItemStack itemstack = new ItemStack(this.item);
            return new MerchantOffer(new ItemStack(FlopItems.BRAT.get(), this.cost), itemstack, this.maxUses, this.flopXp, this.priceMultiplier);
        }
    }
}
