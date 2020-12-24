/*
 * Copyright (c) 2019-2020 GeyserMC. http://geysermc.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/Geyser
 */

package org.geysermc.connector.network.translators.inventory.translators;

import com.nukkitx.protocol.bedrock.data.inventory.ContainerSlotType;
import com.nukkitx.protocol.bedrock.data.inventory.ContainerType;
import com.nukkitx.protocol.bedrock.data.inventory.StackRequestSlotInfoData;
import org.geysermc.connector.network.translators.inventory.BedrockContainerSlot;
import org.geysermc.connector.network.translators.inventory.updater.UIInventoryUpdater;

public class LoomInventoryTranslator extends AbstractBlockInventoryTranslator {
    public LoomInventoryTranslator() {
        super(4, "minecraft:loom[facing=north]", ContainerType.LOOM, UIInventoryUpdater.INSTANCE);
    }

    @Override
    public int bedrockSlotToJava(StackRequestSlotInfoData slotInfoData) {
        if (slotInfoData.getContainer() == ContainerSlotType.LOOM_INPUT) {
            return 0;
        }
        if (slotInfoData.getContainer() == ContainerSlotType.LOOM_DYE) {
            return 1;
        }
        if (slotInfoData.getContainer() == ContainerSlotType.LOOM_MATERIAL) {
            return 2;
        }
        if (slotInfoData.getContainer() == ContainerSlotType.LOOM_RESULT || slotInfoData.getContainer() == ContainerSlotType.CREATIVE_OUTPUT) {
            return 3;
        }
        return super.bedrockSlotToJava(slotInfoData);
    }

    @Override
    public BedrockContainerSlot javaSlotToBedrockContainer(int slot) {
        switch (slot) {
            case 0:
                return new BedrockContainerSlot(ContainerSlotType.LOOM_INPUT, 9);
            case 1:
                return new BedrockContainerSlot(ContainerSlotType.LOOM_DYE, 10);
            case 2:
                return new BedrockContainerSlot(ContainerSlotType.LOOM_MATERIAL, 11);
            case 3:
                return new BedrockContainerSlot(ContainerSlotType.LOOM_RESULT, 50);
        }
        return super.javaSlotToBedrockContainer(slot);
    }

    @Override
    public int javaSlotToBedrock(int slot) {
        switch (slot) {
            case 0:
                return 9;
            case 1:
                return 10;
            case 2:
                return 11;
            case 3:
                return 50;
        }
        return super.javaSlotToBedrock(slot);
    }
}