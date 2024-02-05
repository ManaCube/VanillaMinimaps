/*
 *  Copyright (C) 2024  JNNGL
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jnngl.vanillaminimaps.map.renderer.world;

import com.jnngl.vanillaminimaps.map.Minimap;
import com.jnngl.vanillaminimaps.map.MinimapLayer;
import com.jnngl.vanillaminimaps.map.renderer.MinimapLayerRenderer;
import net.minecraft.util.Mth;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public interface WorldMinimapRenderer extends MinimapLayerRenderer {

  void renderFully(World world, int blockX, int blockZ, byte[] data);

  void updateBlock(Block block, int index, byte[] data);

  @Override
  default void render(Minimap minimap, MinimapLayer layer, byte[] data) {
    Player player = minimap.holder();
    renderFully(player.getWorld(), Mth.floor(player.getLocation().getX()) - 64, Mth.floor(player.getLocation().getZ()) - 64, data);
  }
}
