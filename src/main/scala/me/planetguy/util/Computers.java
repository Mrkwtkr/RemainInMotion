package me.planetguy.util;

import li.cil.oc.api.Driver;
import li.cil.oc.api.driver.Block;
import li.cil.oc.api.network.ManagedEnvironment;
import me.planetguy.remaininmotion.core.Core;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.Loader;
import dan200.computercraft.api.ComputerCraftAPI;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;

public abstract class Computers
{
	public static boolean load;
	
	public static void setup ( )
	{
		load=false;
		if(Loader.isModLoaded("OpenComputers")){
			load=true;
		}
		if(Loader.isModLoaded("ComputerCraft")){
			load=true;
			CC.init();
			
		}
	}
	
	private abstract static class CC{
		static void init(){
			ComputerCraftAPI.registerPeripheralProvider(new IPeripheralProvider(){
				@Override
				public IPeripheral getPeripheral(World world, int x, int y,
						int z, int side) {
					TileEntity te=world.getTileEntity(x, y, z);
					if(te instanceof IPeripheral)
						return (IPeripheral) te;
					else
						return null;
				}
			});
		}
	}
	
	private abstract static class OC{
		static void init(){
			/*
			Driver.add(new Block(){

				@Override
				public boolean worksWith(World world, int x, int y, int z) {
					return world.getTileEntity(x,y,z) instanceof me.planetguy.util.TComputerInterface;
				}

				@Override
				public ManagedEnvironment createEnvironment(World world,
						int x, int y, int z) {
					return new li.cil.oc.api.prefab.ManagedEnvironment(){
						
					};
				}
				
			});
			*/
		}
	}
}