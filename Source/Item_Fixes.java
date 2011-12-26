/**
Item fixes by "1984" of www.rune-server.org
**/

import java.io.*;

public class Item_Fixes  {

  public static ItemDef itemDef(int i,ItemDef itemDef){
	if (i == 15117) {
		itemDef.modelID = 65261;
		itemDef.name = "Veteran cape";
		itemDef.modelZoom = 1513;
		itemDef.modelRotation1 = 279;
		itemDef.modelRotation2 = 948;
		itemDef.modelOffset1 = -3;
		itemDef.modelOffset2 = 24;
		itemDef.stackable = false;
		itemDef.value = 50000;
		itemDef.membersObject = true;
		itemDef.maleEquip1 = 65305;
		itemDef.femaleEquip1 = 65318;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.actions[4] = "Drop";
	}
	
	if (i == 15118) {
		itemDef.modelID = 65271;
		itemDef.name = "Veteran hood";
		itemDef.modelZoom = 760;
		itemDef.modelRotation1 = 11;
		itemDef.modelRotation2 = 81;
		itemDef.modelOffset1 = 1;
		itemDef.modelOffset2 = -3;
		itemDef.stackable = false;
		itemDef.value = 1;
		itemDef.membersObject = true;
		itemDef.maleEquip1 = 65289;
		itemDef.femaleEquip1 = 65314;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.actions[4] = "Drop";
		itemDef.anInt175 = 14;
		itemDef.anInt197 = 7;
	}
	
	if (i == 15119) {
		itemDef.modelID = 65268;
		itemDef.name = "Max hood";
		itemDef.modelZoom = 760;
		itemDef.modelRotation1 = 11;
		itemDef.modelRotation2 = 81;
		itemDef.modelOffset1 = 1;
		itemDef.modelOffset2 = -3;
		itemDef.stackable = false;
		itemDef.value = 1;
		itemDef.membersObject = true;
		itemDef.maleEquip1 = 65291;
		itemDef.femaleEquip1 = 65313;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.actions[4] = "Drop";
		itemDef.editedModelColor = new int[4];
		itemDef.newModelColor = new int[4];
		itemDef.editedModelColor[0] = 65214;
		itemDef.editedModelColor[1] = 65200;
		itemDef.editedModelColor[2] = 65186;
		itemDef.editedModelColor[3] = 62995;
		itemDef.newModelColor[0] = 65214;
		itemDef.newModelColor[1] = 65200;
		itemDef.newModelColor[2] = 65186;
		itemDef.newModelColor[3] = 62995;
		itemDef.anInt175 = 16;
		itemDef.anInt197 = 8;
	}
	
	if (i == 15120) {
		itemDef.modelID = 65262;
		itemDef.name = "Max cape";
		itemDef.modelZoom = 1385;
		itemDef.modelRotation1 = 279;
		itemDef.modelRotation2 = 948;
		itemDef.modelOffset1 = -5;
		itemDef.modelOffset2 = 24;
		itemDef.stackable = false;
		itemDef.value = 3392;
		itemDef.membersObject = true;
		itemDef.maleEquip1 = 65300;
		itemDef.femaleEquip1 = 65322;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.actions[2] = "Customise";
		itemDef.actions[4] = "Drop";
		itemDef.editedModelColor = new int[4];
		itemDef.newModelColor = new int[4];
		itemDef.editedModelColor[0] = 65214;
		itemDef.editedModelColor[1] = 65200;
		itemDef.editedModelColor[2] = 65186;
		itemDef.editedModelColor[3] = 62995;
		itemDef.newModelColor[0] = 65214;
		itemDef.newModelColor[1] = 65200;
		itemDef.newModelColor[2] = 65186;
		itemDef.newModelColor[3] = 62995;
	}
	
	if (i == 15121) {
		itemDef.modelID = 65270;
		itemDef.name = "Completionist cape";
		itemDef.modelZoom = 1316;
		itemDef.modelRotation1 = 252;
		itemDef.modelRotation2 = 1020;
		itemDef.modelOffset1 = -1;
		itemDef.modelOffset2 = 24;
		itemDef.stackable = false;
		itemDef.value = 19264;
		itemDef.membersObject = true;
		itemDef.maleEquip1 = 65297;
		itemDef.femaleEquip1 = 65316;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.actions[2] = "Customise";
		itemDef.actions[3] = "Features";
		itemDef.actions[4] = "Destroy";
		itemDef.editedModelColor = new int[4];
		itemDef.newModelColor = new int[4];
		itemDef.editedModelColor[0] = 65214;
		itemDef.editedModelColor[1] = 65200;
		itemDef.editedModelColor[2] = 65186;
		itemDef.editedModelColor[3] = 62995;
		itemDef.newModelColor[0] = 65214;
		itemDef.newModelColor[1] = 65200;
		itemDef.newModelColor[2] = 65186;
		itemDef.newModelColor[3] = 62995;
	}

	if (i == 15122) {
		itemDef.modelID = 65273;
		itemDef.name = "Completionist hood";
		itemDef.modelZoom = 760;
		itemDef.modelRotation1 = 11;
		itemDef.modelRotation2 = 81;
		itemDef.modelOffset1 = 1;
		itemDef.modelOffset2 = -3;
		itemDef.stackable = false;
		itemDef.value = 1;
		itemDef.membersObject = true;
		itemDef.maleEquip1 = 65292;
		itemDef.femaleEquip1 = 65310;
		itemDef.actions = new String[5];
		itemDef.actions[0] = "null";
		itemDef.actions[1] = "Wear";
		itemDef.actions[4] = "Drop";
		itemDef.editedModelColor = new int[4];
		itemDef.newModelColor = new int[4];
		itemDef.editedModelColor[0] = 65214;
		itemDef.editedModelColor[1] = 65200;
		itemDef.editedModelColor[2] = 65186;
		itemDef.editedModelColor[3] = 62995;
		itemDef.newModelColor[0] = 65214;
		itemDef.newModelColor[1] = 65200;
		itemDef.newModelColor[2] = 65186;
		itemDef.newModelColor[3] = 62995;
		itemDef.anInt175 = 13;
		itemDef.anInt197 = 10;
	}

	if (i == 15123) {
		itemDef.modelID = 65258;
		itemDef.name = "Completionist cape";
		itemDef.modelZoom = 1316;
		itemDef.modelRotation1 = 252;
		itemDef.modelRotation2 = 1020;
		itemDef.modelOffset1 = -1;
		itemDef.modelOffset2 = 24;
		itemDef.stackable = false;
		itemDef.value = 16960;
		itemDef.membersObject = true;
		itemDef.maleEquip1 = 65295;
		itemDef.femaleEquip1 = 65328;
		itemDef.actions = new String[5];
		itemDef.actions[0] = "null";
		itemDef.actions[1] = "Wear";
		itemDef.actions[2] = "Customise";
		itemDef.actions[3] = "Features";
		itemDef.actions[4] = "Destroy";
		itemDef.editedModelColor = new int[4];
		itemDef.newModelColor = new int[4];
		itemDef.editedModelColor[0] = 65214;
		itemDef.editedModelColor[1] = 65200;
		itemDef.editedModelColor[2] = 65186;
		itemDef.editedModelColor[3] = 62995;
		itemDef.newModelColor[0] = 65214;
		itemDef.newModelColor[1] = 65200;
		itemDef.newModelColor[2] = 65186;
		itemDef.newModelColor[3] = 62995;
	}

	if (i == 15124) {
		itemDef.modelID = 65269;
		itemDef.name = "Completionist hood";
		itemDef.modelZoom = 760;
		itemDef.modelRotation1 = 11;
		itemDef.modelRotation2 = 81;
		itemDef.modelOffset1 = 1;
		itemDef.modelOffset2 = -3;
		itemDef.stackable = false;
		itemDef.value = 1;
		itemDef.membersObject = true;
		itemDef.maleEquip1 = 65288;
		itemDef.femaleEquip1 = 65312;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.actions[4] = "Drop";
		itemDef.editedModelColor = new int[4];
		itemDef.newModelColor = new int[4];
		itemDef.editedModelColor[0] = 65214;
		itemDef.editedModelColor[1] = 65200;
		itemDef.editedModelColor[2] = 65186;
		itemDef.editedModelColor[3] = 62995;
		itemDef.newModelColor[0] = 65214;
		itemDef.newModelColor[1] = 65200;
		itemDef.newModelColor[2] = 65186;
		itemDef.newModelColor[3] = 62995;
		itemDef.anInt175 = 12;
		itemDef.anInt197 = 11;
	}
		if(i == 15116)
		{
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 51845;
			itemDef.modelZoom = 2256;
			itemDef.modelRotation1 = 456;
			itemDef.modelRotation2 = 513;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.maleEquip1 = 51795;
			itemDef.femaleEquip1 = 51795;
			itemDef.FemaleWieldY = -10;
			itemDef.name = "Staff of light";
			itemDef.description = "It's a staff of light.";//examine.
		}
		if(i == 15115)
		{
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 51844;
			itemDef.modelZoom = 789;
			itemDef.modelRotation1 = 69;
			itemDef.modelRotation2 = 1743;
			itemDef.modelOffset1 = -4;
			itemDef.modelOffset2 = 0;
			itemDef.maleEquip1 = 51797;
			itemDef.femaleEquip1 = 51819;
			itemDef.name = "Full slayer helmet";
			itemDef.description = "It's a full slayer helmet.";//examine.
		}
		if(i == 15001)
		{
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 40915;
			itemDef.modelZoom = 1616;
			itemDef.modelRotation1 = 396;
			itemDef.modelRotation2 = 1050;
			itemDef.modelOffset1 = -3;
			itemDef.modelOffset2 = 4;
			itemDef.maleEquip1 = 40942;
			itemDef.femaleEquip1 = 40942;
			itemDef.FemaleWieldY = -10;
			itemDef.name = "Elysian spirit shield";
			itemDef.description = "It's an Elysian spirit shield.";
		}
		if(i == 15002)
		{
			itemDef.actions = new String[5];//menu
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 40922;//inventory/drop model
			itemDef.modelZoom = 1616;//Model Zoom
			itemDef.modelRotation1 = 396;//rotation 1
			itemDef.modelRotation2 = 1050;//rotation 2
			itemDef.modelOffset1 = -3;//model offset 1
			itemDef.modelOffset2 = 4;//model offset 2
			itemDef.maleEquip1 = 40944;//male wield ModelId
			itemDef.femaleEquip1 = 40944;//female wield ModelId
			itemDef.FemaleWieldY = -10;
			itemDef.name = "Arcane spirit shield";//name
			itemDef.description = "It's a Arcane spirit shield.";//name
		}
		if(i == 15003)
		{
			itemDef.actions = new String[5];//menu
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 40921;//inventory/drop model
			itemDef.modelZoom = 1616;//Model Zoom
			itemDef.modelRotation1 = 396;//rotation 1
			itemDef.modelRotation2 = 1050;//rotation 2
			itemDef.modelOffset1 = -3;//model offset 1
			itemDef.modelOffset2 = 4;//model offset 2
			itemDef.maleEquip1 = 40939;//male wield ModelId
			itemDef.femaleEquip1 = 40939;//female wield ModelId
			itemDef.FemaleWieldY = -10;
			itemDef.name = "Divine spirit shield";//name
			itemDef.description = "It's a Divine spirit shield.";//name
		}
		if(i == 15004)
		{
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 40920;
			itemDef.modelZoom = 1616;
			itemDef.modelRotation1 = 396;
			itemDef.modelRotation2 = 1050;
			itemDef.modelOffset1 = -3;
			itemDef.modelOffset2 = 4;
			itemDef.maleEquip1 = 40940;
			itemDef.femaleEquip1 = 40940;
			itemDef.FemaleWieldY = -10;
			itemDef.name = "Spectral spirit shield";
			itemDef.description = "It's a Spectral spirit shield.";
		}
		if(i == 15005)
		{
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 40913;
			itemDef.modelZoom = 1616;
			itemDef.modelRotation1 = 396;
			itemDef.modelRotation2 = 1050;
			itemDef.modelOffset1 = -3;
			itemDef.modelOffset2 = 4;
			itemDef.maleEquip1 = 40941;
			itemDef.femaleEquip1 = 40941;
			itemDef.FemaleWieldY = -10;
			itemDef.name = "Blessed spirit shield";
			itemDef.description = "It's a Blessed spirit shield.";
		}
		if(i == 15006)
		{
			itemDef.actions = new String[5];//menu
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 40919;//inventory/drop model
			itemDef.modelZoom = 1616;//Model Zoom
			itemDef.modelRotation1 = 396;//rotation 1
			itemDef.modelRotation2 = 1050;//rotation 2
			itemDef.modelOffset1 = -3;//model offset 1
			itemDef.modelOffset2 = 4;//model offset 2
			itemDef.maleEquip1 = 40943;//male wield ModelId
			itemDef.femaleEquip1 = 40943;//female wield ModelId
			itemDef.FemaleWieldY = -10;
			itemDef.name = "Spirit shield";//name
			itemDef.description = "It's a Spirit shield.";//name
		}
		if(i >= 1174 && i <= 1435) {
			itemDef.FemaleWieldY = -10;
		}
		if(i == 2430){
			itemDef.name = "Special Restore Potion";
			itemDef.description = "It's a potion that restores special!";
		}
		if(i == 2438){
			itemDef.name = "Overload";
			itemDef.description = " An overload potion";
		}
		if(i >= 656 && i <= 665) {
			itemDef.FemaleWieldY = -10;
		}
		switch(itemDef.id) {
			case 4151:
			case 11694:
			case 11696:
			case 2651:
			case 1949:
			case 11698:
			case 11700:
			case 2902:
			case 2912:
			case 2922:
			case 2932:
			case 2942:
			case 11730:
			case 20072:
			case 1017:
			case 656:
			case 1042:
			case 1038:
			case 1040:
			case 1044:
			case 1046:
			case 1048:
			case 1053:
			case 1055:
			case 1057:
			case 74:
			case 1137:
			case 1139:
			case 1141:
			case 1143:
			case 1145:
			case 1147:
			case 1149:
			case 1151:
			case 1153:
			case 1155:
			case 1157:
			case 1159:
			case 1161:
			case 1163:
			case 1165:
			case 1167:
			case 1169:
			case 1171:
			case 6629:
			case 2657:
			case 4675:
			case 2665:
			case 2673:
			case 6631:
			case 11283:
			case 4587:
			case 11284:
			case 11285:
			case 11286:
			case 2758:
			case 6524:
			case 2522:
			case 6523:
			case 2900:
			case 4225:
			case 4212:
			case 2910:
			case 4235:
			case 2920:
			case 2930:
			case 4224:
			case 3488:
			case 4156:
			case 2659:
			case 2667:
			case 3122:
			case 2940:
			case 2675:
			case 2890:
			case 1173:
			case 580:
			itemDef.FemaleWieldY = -10;
			break;
		}
		return itemDef;
	}

  public static void Items(int i){
  ItemDef itemDef = ItemDef.forID(i);

    switch(i) {

		}	
		
		String[] showBlack = {
			"charm", "Obsidian cape", "Grim reaper hood", "Skeleton", "Dragon platebody", "Dragon chainbody",
			"Top hat", "Anger sword", "Anger spear", "Anger mace", "Anger axe",
			"Body rune", "Third-age robe", "Third-age amulet", "Ava's", "eyepatch", "Silverlight", "talisman staff",
			"Ringmaster hat", "Investigator's trousers", "Obsidian cape", "Fire rune"
		};
		for(int j = 0; j < showBlack.length; j++ ) {
			if(itemDef.name.endsWith(showBlack[j]) || itemDef.name.contains(showBlack[j])) {
					itemDef.editedModelColor = new int[1];
					itemDef.newModelColor = new int[1];
					itemDef.editedModelColor[0] = 0;
					itemDef.newModelColor[0] = 0;
			}
		}
				
			String[] femWepFix = {
					"sword", "scimitar", "mace", "whip", "staff", "sceptre", "javelin", "spear",
					"knife", "axe", "hammer", "hatchet", "halberd", "maul", "bow", "dagger", "hasta",
					"salamander", " dart", "mjolnir", "flail", "trident", "cane", "anchor", "Tzhaar",
					"Toktz", "cutlass", "blade", "wand",
					"Rubber chicken", "Scythe", "Butterfly net", "Inferno adze", "Mouse_toy", "Silverlight",
					"Darklight", "Snowball", "Hand cannon", "Staff"
			};
			for(int j = 0; j < femWepFix.length; j++ ) {
				if((itemDef.name.endsWith(femWepFix[j]) || itemDef.name.contains(femWepFix[j]) || ((i >= 7433) && (i <= 7452)))
						&& !itemDef.name.contains("Arcane") && !itemDef.name.contains("Fishbowl")
						&& !itemDef.name.contains("Rainbow") && !itemDef.name.contains("Korasi's")
						) {
						itemDef.FemaleWieldY = -10;
						itemDef.FemaleWieldX = -2;
						itemDef.FemaleWieldZ = 2;
				}
			}
 
               
			String[] femShieldFix = {
                        "shield", "book", "defender", "lantern", "Toktz-ket-xil",
                };
                for(int j = 0; j < femShieldFix.length; j++ ) {
                        if(itemDef.name.endsWith(femShieldFix[j]) || itemDef.name.contains(femShieldFix[j])) {
                                itemDef.FemaleWieldY = -14;
                                itemDef.FemaleWieldX = -4;
                                itemDef.FemaleWieldZ = 7;
                        }
                }
      
        if(itemDef.name.contains("spirit shield")){
			itemDef.FemaleWieldY = -5;
			itemDef.FemaleWieldX = -4;
			itemDef.FemaleWieldZ = 7;
        }
        if(itemDef.name.contains("Dragonfire shield")){
			itemDef.FemaleWieldY = 10;
			itemDef.FemaleWieldX = -6;
			itemDef.FemaleWieldZ = 6;
        }
        if(itemDef.name.contains("Fire cape")){
			itemDef.FemaleWieldY = -6;
        }
        if(itemDef.name.contains("Amulet of fury")){
			itemDef.FemaleWieldY = 5;
        }
        if((i >= 8714) && (i <= 8744)){
			itemDef.FemaleWieldY = 0;
			itemDef.FemaleWieldX = -4;
			itemDef.FemaleWieldZ = -4;
        }
	}
}
