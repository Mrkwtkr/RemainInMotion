package me.planetguy.remaininmotion ;

import me.planetguy.remaininmotion.client.RIMTileEntityRenderer;
import me.planetguy.remaininmotion.core.Configuration;
import me.planetguy.remaininmotion.util.Debug;

public class MotiveSpectreRenderer extends RIMTileEntityRenderer
{
	@Override
	public void Render ( net . minecraft . tileentity . TileEntity TileEntity , float PartialTick )
	{
		
		MotiveSpectreEntity Spectre = ( MotiveSpectreEntity ) TileEntity ;

		if ( Spectre . RenderCacheKey == null )
		{
			return ;
		}

		{
			double Offset ;
			
			if ( Configuration . CarriageMotion . RenderInFinalPositionDuringLag && ( Spectre . TicksExisted >= Configuration . CarriageMotion . MotionDuration ) )
			{
				Offset = 1 ;
			}
			else
			{
				Offset = Spectre . Velocity * ( Spectre . TicksExisted + PartialTick ) ;
			}

			Render . Translate ( Offset * Spectre . MotionDirection . DeltaX - Spectre . xCoord , Offset * Spectre . MotionDirection . DeltaY - Spectre . yCoord ,
				Offset * Spectre . MotionDirection . DeltaZ - Spectre . zCoord ) ;
		}

		Integer DisplayList = CarriageRenderCache . Lookup ( Spectre . RenderCacheKey ) ;

		if ( DisplayList != null )
		{
			Debug.dbg("No cached display list!");
			Render . ResetBoundTexture ( ) ;

			Render . ExecuteDisplayList ( DisplayList ) ;

			Render . ResetBoundTexture ( ) ;
		}
	}
}