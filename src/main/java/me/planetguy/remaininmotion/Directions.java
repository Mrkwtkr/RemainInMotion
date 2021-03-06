package me.planetguy.remaininmotion ;

import net.minecraftforge.common.util.ForgeDirection;

public enum Directions
{
	NegY ( ForgeDirection . DOWN ) ,
	PosY ( ForgeDirection . UP ) ,
	NegZ ( ForgeDirection . NORTH ) ,
	PosZ ( ForgeDirection . SOUTH ) ,
	NegX ( ForgeDirection . WEST ) ,
	PosX ( ForgeDirection . EAST ) ,
	
	Null(null);

	public int DeltaX ;
	public int DeltaY ;
	public int DeltaZ ;

	public int Opposite ;

	private Directions ( ForgeDirection Direction )
	{
		if(Direction!=null){
			DeltaX = Direction . offsetX ;
			DeltaY = Direction . offsetY ;
			DeltaZ = Direction . offsetZ ;

			Opposite = Direction . getOpposite ( ) . ordinal ( ) ;
		}
	}

	public Directions Opposite ( )
	{
		return ( values ( ) [ Opposite ] ) ;
	}
}
