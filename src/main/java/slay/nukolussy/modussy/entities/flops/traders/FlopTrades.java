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
import slay.nukolussy.modussy.item.ModItems;

import javax.annotation.Nullable;
import java.util.Map;

public class FlopTrades {
    private static final int DEFAULT_SUPPLY = 36;
    private static final int COMMON_ITEMS_SUPPLY = 69;
    private static final int UNCOMMON_ITEMS_SUPPLY = 12;

    public static final Map<IFlopTraderVariant, Int2ObjectMap<ItemListing[]>> TRADES =
            Util.make(Maps.newHashMap(), (tag) -> {
                tag.put(Jiafei.Variant.AESTHETIC, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForSlaginium(ModItems.JIAFEI_PRODUCT.get(), COMMON_ITEMS_SUPPLY, 1),
                        new SlaginiumForProducts(ModItems.JIAFEI_HELMET.get(), 4, DEFAULT_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.JIAFEI_CHESTPLATE.get(), 5, DEFAULT_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.JIAFEI_LEGGINGS.get(), 5, DEFAULT_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.JIAFEI_BOOTS.get(), 4, DEFAULT_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(ModItems.JIAFEI_PERFUME.get(), 4, UNCOMMON_ITEMS_SUPPLY, 6),
                        new InfusedSlaginiumForProducts(ModItems.DEELDO.get(), 3, UNCOMMON_ITEMS_SUPPLY, 6) // temporary. will be replaced with jiafei jetpacks
                })));
                tag.put(Jiafei.Variant.MUSICIAN, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForSlaginium(ModItems.JIAFEI_PRODUCT.get(), COMMON_ITEMS_SUPPLY, 1),
                        new SlaginiumForProducts(ModItems.DISC_CJ1.get(), 2, DEFAULT_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_JIAFEI.get(), 3, DEFAULT_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_J1.get(), 3, UNCOMMON_ITEMS_SUPPLY, 6),
                        new SlaginiumForProducts(ModItems.DISC_J2.get(), 3, UNCOMMON_ITEMS_SUPPLY, 6),
                        new InfusedSlaginiumForProducts(ModItems.DISC_J4.get(), 3, DEFAULT_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(ModItems.DISC_J5.get(), 5, UNCOMMON_ITEMS_SUPPLY, 12)
                })));
                tag.put(Jiafei.Variant.UTILITIES, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForSlaginium(ModItems.JIAFEI_PRODUCT.get(), COMMON_ITEMS_SUPPLY, 1),
                        new SlaginiumForProducts(ModItems.CVM.get(), 2, UNCOMMON_ITEMS_SUPPLY, 6),
                        new SlaginiumForProducts(ModItems.JIAFEI_AXE.get(), 2, DEFAULT_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.JIAFEI_SHOVEL.get(), 1,DEFAULT_SUPPLY,2),
                        new SlaginiumForProducts(ModItems.JIAFEI_PICKAXE.get(), 2, DEFAULT_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(ModItems.JIAFEI_HAMMER.get(), 3, DEFAULT_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(ModItems.JIAFEI_SICKLE.get(), 2, DEFAULT_SUPPLY, 2)
                })));
                tag.put(NickiMinaj.Variant.VARIANT, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForSlaginium(ModItems.HAIRUSSY.get(), COMMON_ITEMS_SUPPLY, 1),
                        new SlaginiumForProducts(ModItems.BRA.get(), 2, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_C16.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_C23.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_C26.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(ModItems.DISC_JC2.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6),
                        new InfusedSlaginiumForProducts(ModItems.ROSETOY.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6)
                })));
                tag.put(Ranvision.Variant.KPOP, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForSlaginium(ModItems.JIAFEI_PRODUCT.get(), COMMON_ITEMS_SUPPLY, 1),
                        new SlaginiumForProducts(ModItems.DISC_C1.get(), 2, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_C5.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_C10.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_C14.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(ModItems.DISC_CPM1.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6),
                        new InfusedSlaginiumForProducts(ModItems.WONYOUNG_ESSENCE.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6)
                })));
                tag.put(Ranvision.Variant.CULTURAL, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForSlaginium(ModItems.CUPCAKE.get(), COMMON_ITEMS_SUPPLY, 1),
                        new SlaginiumForProducts(ModItems.DISC_C4.get(), 2, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_C8.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_C11.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_C17.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(ModItems.DISC_C18.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6),
                        new InfusedSlaginiumForProducts(ModItems.CVMTITPLASM.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6)
                })));
                tag.put(Ranvision.Variant.POP, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForSlaginium(ModItems.ARANA_GRANDE.get(), COMMON_ITEMS_SUPPLY, 1),
                        new SlaginiumForProducts(ModItems.DISC_C6.get(), 2, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_C7.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_C9.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_CJ1.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(ModItems.DISC_J3.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6),
                        new InfusedSlaginiumForProducts(ModItems.SLAGINIUM_YASSIFIER_PREMIUM.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6)
                })));
                tag.put(Ranvision.Variant.EVENT, toIntMap(ImmutableMap.of(1, new ItemListing[]{
                        new ProductsForSlaginium(ModItems.CVMTITPLASM.get(), COMMON_ITEMS_SUPPLY, 1),
                        new SlaginiumForProducts(ModItems.DISC_C23.get(), 2, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_C24.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_J5.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new SlaginiumForProducts(ModItems.DISC_PM1.get(), 4, COMMON_ITEMS_SUPPLY, 2),
                        new InfusedSlaginiumForProducts(ModItems.DISC_RANVISION.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6),
                        new InfusedSlaginiumForProducts(ModItems.KYLIE_JENNER_LIPSTICK.get(), 6, UNCOMMON_ITEMS_SUPPLY, 6)
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
            return new MerchantOffer(itemstack, new ItemStack(ModItems.SLAGINIUM.get(), 12), this.maxUses, this.flopXp, this.priceMultiplier);
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
            return new MerchantOffer(new ItemStack(ModItems.SLAGINIUM.get(), this.cost), itemstack, this.maxUses, this.flopXp, this.priceMultiplier);
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
            return new MerchantOffer(new ItemStack(ModItems.INFUSED_SLAGINIUM.get(), this.cost), itemstack, this.maxUses, this.flopXp, this.priceMultiplier);
        }
    }
}
