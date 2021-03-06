package flaxbeard.immersivepetroleum.common.compat.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.liquid.ILiquidStack;
import flaxbeard.immersivepetroleum.api.crafting.PumpjackHandler;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.immersivepetroleum.Reservoir")
@ZenRegister
public class ReservoirTweaker
{
	@ZenMethod
	public static void registerReservoir(String name, ILiquidStack fluid, int minSize, int maxSize, int replenishRate, int weight)
	{

		if (name.isEmpty())
		{
			CraftTweakerAPI.logError("Reservoir name can not be empty string!");
		}
		else if (minSize <= 0)
		{
			CraftTweakerAPI.logError("Reservoir minSize has to be at least 1mb!");
		}
		else if (maxSize < minSize)
		{
			CraftTweakerAPI.logError("Reservoir maxSize can not be smaller than minSize!");
		}
		else if (weight <= 1)
		{
			CraftTweakerAPI.logError("Reservoir weight has to be greater than or equal to 1!");
		}

		String rFluid = fluid.getName();

		PumpjackHandler.addReservoir(name, rFluid, minSize, maxSize, replenishRate, weight);
	}
}
