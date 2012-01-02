import java.io.*;
import sign.signlink;

public final class ItemDef {

	public static ItemDef forID(int i) {
		for (int j = 0; j < 10; j++)
			if (cache[j].id == i)
				return cache[j];
		cacheIndex = (cacheIndex + 1) % 10;
		ItemDef itemDef = cache[cacheIndex];
		stream.currentOffset = streamIndices[i];
		itemDef.id = i;
		itemDef.setDefaults();
		itemDef.readValues(stream);
if (itemDef.editedModelColor != null) {
			for (int i2 = 0; i2 < itemDef.editedModelColor.length; i2++) {
				if (itemDef.newModelColor[i2] == 0) {
					itemDef.newModelColor[i2] = 1;
				}
			}
		}
		if (itemDef.certTemplateID != -1)
			itemDef.toNote();
		if (itemDef.lentItemID != -1)
			itemDef.toLend();
		if (!isMembers && itemDef.membersObject) {
			itemDef.name = "Members Object";
			itemDef.description = "Login to a members' server to use this object.";
			itemDef.groundActions = null;
			itemDef.itemActions = null;
			itemDef.team = 0;
		}
				if (i >= 1) {
			itemDef.aByte154 = 0;
			for(String b:femaleItems) {
				if (itemDef.name.toLowerCase().contains(b)) {
					itemDef.aByte154 = -12;
				}
			}
			for(String c:femaleItemsTwo) {
				if (itemDef.name.toLowerCase().contains(c)) {
					itemDef.aByte154 = -24;
				}
			}
			for(String d:femaleItemsThree) {
				if (itemDef.name.toLowerCase().contains(d)) {
					itemDef.aByte154 = 0;
				}
			}
		}
		switch (itemDef.id) {
				case 995:
			itemDef.name = "Coins";
			itemDef.itemActions = new String[5];
			itemDef.itemActions[4] = "Drop";
			itemDef.itemActions[3] = "Add-to-pouch";
		break;
		
		case 19342:
		itemDef.editedModelColor = new int[1];
		itemDef.newModelColor = new int[1];
		itemDef.editedModelColor[0] = 0;
		itemDef.newModelColor[0] = 2;
		break;
		case 19337:
		itemDef.editedModelColor = new int[1];
		itemDef.newModelColor = new int[1];
		itemDef.editedModelColor[0] = 0;
		itemDef.newModelColor[0] = 2;
		break;
		case 14479:
		itemDef.editedModelColor = new int[1];
		itemDef.newModelColor = new int[1];
		itemDef.editedModelColor[0] = 0;
		itemDef.newModelColor[0] = 2;
		break;
		
		case 600:
		itemDef.name = "Rules book";
		itemDef.description = "A book with all the rules of TheNewScapers in it";
		itemDef.itemActions[4] = "Drop";
		break;
	
		case 607:
		itemDef.name = "Money scroll";
		itemDef.itemActions[0] = "Activate";
		itemDef.description = "Activating this scroll will give me 10,000,000 Gold coins!";
		itemDef.itemActions[4] = "Drop";
		break;
	
		case 2528:
		itemDef.name = "Skill advance lamp";
		itemDef.itemActions[0] = "Activate";
		itemDef.description = "Activating this lamp will open the 'Skill Advance Tab'";
		itemDef.itemActions[4] = "Drop";
		break;

		case 773:
		itemDef.name = "Owner ring";
		itemDef.description = "A ring that belongs to Owner Its just Me, return it.";
		itemDef.itemActions[4] = "Drop";
		break;
	
		case 13362:
		itemDef.modelid = 62714;
		itemDef.name = "Torva full helm";
		itemDef.description = "Torva full helm.";
		itemDef.modelZoom = 672;
		itemDef.modelRotationY = 85;
		itemDef.modelRotationX = 1867;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = -3;
		itemDef.anInt165 = 62738;
		itemDef.anInt200 = 62754;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Check-charges";
		itemDef.itemActions[4] = "Drop";
		break;	
case 13360:
		itemDef.modelid = 62701;
		itemDef.name = "Torva platelegs";
		itemDef.description = "Torva platelegs.";
		itemDef.modelZoom = 1740;
		itemDef.modelRotationY = 474;
		itemDef.modelRotationX = 2045;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = -5;
		itemDef.anInt165 = 62743;
		itemDef.anInt200 = 62760;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Check-charges";
		itemDef.itemActions[4] = "Drop";
	break;
	case 14005:
		itemDef.name = "Robin hood hat";
		itemDef.modelid = 3021;
itemDef.editedModelColor = new int[3];
itemDef.editedModelColor[0] = 15252;
itemDef.editedModelColor[1] = 17294;
itemDef.editedModelColor[2] = 15009;
itemDef.newModelColor = new int[3];
itemDef.newModelColor[0] = 7973;
itemDef.newModelColor[1] = 7730;
itemDef.newModelColor[2] = 10015;
		itemDef.modelZoom = 650;
		itemDef.modelRotationY = 2044;
		itemDef.modelRotationX = 256;
		itemDef.modelOffset1 = -3;
		itemDef.modelOffset2 = -2;
		itemDef.anInt165 = 3378;
		itemDef.anInt200 = 3382;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
	break;
	
				case 14013:
				itemDef.name = "Trickster robe";
				itemDef.description = "Its a Trickster robe";
				itemDef.anInt200 = 44786;
				itemDef.anInt165 = 44786;
				itemDef.modelid = 45329;
				itemDef.modelRotationY = 593;
				itemDef.modelRotationX = 2041;
				itemDef.modelZoom = 1420;
				itemDef.modelOffset2 = 0;
				itemDef.modelOffset1 = 0;
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
			break;
			case 14014:
				itemDef.name = "Trickster robe legs";
				itemDef.description = "Its a Trickster robe";
				itemDef.anInt200 = 44770;
				itemDef.anInt165 = 44770;
				itemDef.modelid = 45335;
				itemDef.modelRotationY = 567;
				itemDef.modelRotationX = 1023;
				itemDef.modelZoom = 2105;
				itemDef.modelOffset2 = 0;
				itemDef.modelOffset1 = 0;
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
			break;	
			case 14015:
				itemDef.name = "Trickster helm";
				itemDef.description = "Its a Trickster helm";
				itemDef.anInt200 = 44764;
				itemDef.anInt165 = 44764;
				itemDef.modelid = 45328;
				itemDef.modelRotationY = 5;
				itemDef.modelRotationX = 1889;
				itemDef.modelZoom = 738;
				itemDef.modelOffset2 = 0;
				itemDef.modelOffset1 = 0;
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
			break;
			case 14016:
				itemDef.modelid = 45316;
				itemDef.name = "Trickster boots";
				itemDef.modelZoom = 848;
				itemDef.modelRotationX = 141;
				itemDef.modelRotationY = 141;
				itemDef.modelOffset1 = -9;
				itemDef.modelOffset2 = 0;
				itemDef.stackable = false;
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
				itemDef.anInt200 = 44757;
				itemDef.anInt165 = 44757;
			break;
			case 14017:
				itemDef.modelid = 45317;
				itemDef.name = "Trickster gloves";
				itemDef.modelZoom = 830;
				itemDef.modelRotationX = 150;
				itemDef.modelRotationY = 536;
				itemDef.modelOffset1 = 1;
				itemDef.modelOffset2 = 3;
				itemDef.stackable = false;
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
				itemDef.anInt200 = 44761;
				itemDef.anInt165 = 44761;
			break;
			
			case 14028:
		itemDef.name = "Completionist Cape";
		itemDef.description = "We would pat you on the back but this cape would get in the way.";
		itemDef.modelid = 65270;
		itemDef.editedModelColor = new int [3];
		itemDef.newModelColor = new int [3];
		itemDef.editedModelColor[0] = 65214;
		itemDef.newModelColor[0] = 122;
		itemDef.editedModelColor[1] = 65200;
		itemDef.newModelColor[1] = 122;
		itemDef.editedModelColor[2] = 65186;
		itemDef.newModelColor[2] = 122;
		itemDef.anInt165 = 65295;
		itemDef.anInt200 = 65295;
		itemDef.modelid = 65258;
		itemDef.modelRotationY = 252;
		itemDef.modelRotationX = 1020;
		itemDef.modelZoom = 1316;
		itemDef.modelOffset2 = -1;
		itemDef.modelOffset1 = 14;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Customise";
		itemDef.itemActions[3] = "Features";
		itemDef.itemActions[4] = "Destroy";
	break;
				case 14029:
		itemDef.name = "Completionist Cape";
		itemDef.description = "We would pat you on the back but this cape would get in the way.";
		itemDef.modelid = 65270;
		itemDef.editedModelColor = new int [3];
		itemDef.newModelColor = new int [3];
		itemDef.editedModelColor[0] = 65214;
		itemDef.newModelColor[0] = 8128;
		itemDef.editedModelColor[1] = 65200;
		itemDef.newModelColor[1] = 8128;
		itemDef.editedModelColor[2] = 65186;
		itemDef.newModelColor[2] = 8128;
		itemDef.anInt165 = 65295;
		itemDef.anInt200 = 65295;
		itemDef.modelid = 65258;
		itemDef.modelRotationY = 252;
		itemDef.modelRotationX = 1020;
		itemDef.modelZoom = 1316;
		itemDef.modelOffset2 = -1;
		itemDef.modelOffset1 = 14;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Customise";
		itemDef.itemActions[3] = "Features";
		itemDef.itemActions[4] = "Destroy";
	break;
			
			case 14031:
		itemDef.name = "Completionist Cape";
		itemDef.description = "We would pat you on the back but this cape would get in the way.";
		itemDef.anInt165 = 65295;
		itemDef.anInt200 = 65295;
		itemDef.modelid = 65258;
		itemDef.modelRotationY = 252;
		itemDef.modelRotationX = 1020;
		itemDef.modelZoom = 1316;
		itemDef.modelOffset2 = -1;
		itemDef.modelOffset1 = 14;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Customise";
		itemDef.itemActions[3] = "Features";
		itemDef.itemActions[4] = "Destroy";
		itemDef.editedModelColor = new int[4];
		itemDef.newModelColor = new int[4];
		itemDef.editedModelColor[0] = 65214;
		itemDef.editedModelColor[1] = 65200;
		itemDef.editedModelColor[2] = 65186;
		itemDef.editedModelColor[3] = 62995;
		itemDef.newModelColor[0] = 11200;
		itemDef.newModelColor[1] = 4550;
		itemDef.newModelColor[2] = 6073;
		itemDef.newModelColor[3] = 11200;
		break;
		
					case 14034:
		itemDef.name = "Completionist Cape";
		itemDef.description = "We would pat you on the back but this cape would get in the way.";
		itemDef.anInt165 = 65295;
		itemDef.anInt200 = 65295;
		itemDef.modelid = 65258;
		itemDef.modelRotationY = 252;
		itemDef.modelRotationX = 1020;
		itemDef.modelZoom = 1316;
		itemDef.modelOffset2 = -1;
		itemDef.modelOffset1 = 14;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Customise";
		itemDef.itemActions[3] = "Features";
		itemDef.itemActions[4] = "Destroy";
		/*itemDef.editedModelColor = new int[4];
		itemDef.newModelColor = new int[4];
		itemDef.editedModelColor[0] = 65214;
		itemDef.editedModelColor[1] = 65200;
		itemDef.editedModelColor[2] = 65186;
		itemDef.editedModelColor[3] = 62995;
		itemDef.newModelColor[0] = 11200;
		itemDef.newModelColor[1] = 4550;
		itemDef.newModelColor[2] = 6073;
		itemDef.newModelColor[3] = 11200;*/
		//delete comments for yellow recolor get rid of the commentation.
		break;
		
					case 14032://new
		itemDef.name = "Completionist Cape";
		itemDef.description = "We would pat you on the back but this cape would get in the way.";
		itemDef.anInt165 = 65295;
		itemDef.anInt200 = 65295;
		itemDef.modelid = 65258;
		itemDef.modelRotationY = 252;
		itemDef.modelRotationX = 1020;
		itemDef.modelZoom = 1316;
		itemDef.modelOffset2 = -1;
		itemDef.modelOffset1 = 14;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Customise";
		itemDef.itemActions[3] = "Features";
		itemDef.itemActions[4] = "Destroy";
		itemDef.editedModelColor = new int[4];
		itemDef.newModelColor = new int[4];
		itemDef.editedModelColor[0] = 65214;
		itemDef.editedModelColor[1] = 65200;
		itemDef.editedModelColor[2] = 65186;
		itemDef.editedModelColor[3] = 62995;
		itemDef.newModelColor[0] = 2;
		itemDef.newModelColor[1] = 2;
		itemDef.newModelColor[2] = 61;
		itemDef.newModelColor[3] = 61;
		break;
		case 14033://new
		itemDef.name = "Completionist hood";
		itemDef.description = "We would pat you on the back but this cape would get in the way.";
		itemDef.anInt165 = 65292;
		itemDef.anInt200 = 65310;
		itemDef.modelid = 65273;
		itemDef.modelRotationY = 11;
		itemDef.modelRotationX = 81;
		itemDef.modelZoom = 760;
		itemDef.modelOffset2 = 1;
		itemDef.modelOffset1 = -3;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Customise";
		itemDef.itemActions[3] = "Features";
		itemDef.itemActions[4] = "Destroy";
		itemDef.editedModelColor = new int[4];
		itemDef.newModelColor = new int[4];
		itemDef.editedModelColor[0] = 65214;
		itemDef.editedModelColor[1] = 65200;
		itemDef.editedModelColor[2] = 65186;
		itemDef.editedModelColor[3] = 62995;
		itemDef.newModelColor[0] = 61;
		itemDef.newModelColor[1] = 61;
		itemDef.newModelColor[2] = 61;
		itemDef.newModelColor[3] = 61;
		break;
		case 14035://new
		itemDef.name = "Completionist hood";
		itemDef.description = "We would pat you on the back but this cape would get in the way.";
		itemDef.anInt165 = 65292;
		itemDef.anInt200 = 65310;
		itemDef.modelid = 65273;
		itemDef.modelRotationY = 11;
		itemDef.modelRotationX = 81;
		itemDef.modelZoom = 760;
		itemDef.modelOffset2 = 1;
		itemDef.modelOffset1 = -3;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Customise";
		itemDef.itemActions[3] = "Features";
		itemDef.itemActions[4] = "Destroy";
		itemDef.editedModelColor = new int[4];
		itemDef.newModelColor = new int[4];
		itemDef.editedModelColor[0] = 65214;
		itemDef.editedModelColor[1] = 65200;
		itemDef.editedModelColor[2] = 65186;
		itemDef.editedModelColor[3] = 62995;
		itemDef.newModelColor[0] = 11200;
		itemDef.newModelColor[1] = 11200;
		itemDef.newModelColor[2] = 6073;
		itemDef.newModelColor[3] = 11200;
		break;
		case 14036://new
		itemDef.name = "Abyssal vine whip";
		itemDef.modelid = 10247;
		itemDef.modelZoom = 848;
		itemDef.modelRotationY = 324;
		itemDef.modelRotationX = 1808;
		itemDef.modelOffset1 = 5;
		itemDef.modelOffset2 = 38;
		itemDef.anInt165 = 10253;
		itemDef.anInt200 = 10253;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.description = "An Abyssal Whip with a vine attached to it";
		break;
		case 14037://new
		itemDef.name = "Ornate katana";
		itemDef.modelid = 6277;
		itemDef.modelZoom = 2025;
		itemDef.modelRotationY = 593;
		itemDef.modelRotationX = 2040;
		itemDef.modelOffset1 = 5;
		itemDef.modelOffset2 = 1;
		itemDef.anInt165 = 5324;
		itemDef.anInt200 = 5324;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.description = "An Abyssal Whip with a vine attached to it";
		break;
		case 14038://new
		itemDef.name = "Gorilla mask";
		itemDef.modelid = 658;
		itemDef.modelZoom = 919;
		itemDef.modelRotationY = 184;
		itemDef.modelRotationX = 225;
		itemDef.modelOffset1 = -1;
		itemDef.modelOffset2 = -5;
		itemDef.anInt165 = 65508;
		itemDef.anInt200 = 65509;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.description = "Oh my god.. mommie?";
		break;		
		case 4714://new
		itemDef.name = "Ahrim's robeskirt";
		itemDef.modelid = 6577;
		itemDef.modelZoom = 1730;
		itemDef.modelRotationY = 504;
		itemDef.modelRotationX = 0;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = -4;
		itemDef.anInt165 = 6659;
		itemDef.anInt200 = 6659;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.description = "It's a Ahrim's robeskirt";
		itemDef.anInt204 = 128;//might work
		break;
		case 14039://new
		itemDef.name = "Completionist hood";
		itemDef.description = "We would pat you on the back but this cape would get in the way.";
		itemDef.anInt165 = 65292;
		itemDef.anInt200 = 65310;
		itemDef.modelid = 65273;
		itemDef.modelRotationY = 11;
		itemDef.modelRotationX = 81;
		itemDef.modelZoom = 760;
		itemDef.modelOffset2 = 1;
		itemDef.modelOffset1 = -3;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Customise";
		itemDef.itemActions[3] = "Features";
		itemDef.itemActions[4] = "Destroy";
		itemDef.editedModelColor = new int[4];
		itemDef.newModelColor = new int[4];
		/*itemDef.editedModelColor[0] = 65214;
		itemDef.editedModelColor[1] = 65200;
		itemDef.editedModelColor[2] = 65186;
		itemDef.editedModelColor[3] = 62995;
		itemDef.newModelColor[0] = 11200;
		itemDef.newModelColor[1] = 11200;
		itemDef.newModelColor[2] = 6073;
		itemDef.newModelColor[3] = 11200;*/
		break;
				case 14040://new
		itemDef.name = "Akrisae's war mace";
		itemDef.description = "It's a Akrisae's war mace";
		itemDef.anInt165 = 53543;
		itemDef.anInt200 = 53543;
		itemDef.modelid = 54583;
		itemDef.modelRotationY = 189;
		itemDef.modelRotationX = 673;
		itemDef.modelZoom = 1447;
		itemDef.modelOffset2 = 11;
		itemDef.modelOffset1 = 7;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Destroy";
		break;
		case 14041://new
		itemDef.name = "Gilded Dragon pickaxe";
		itemDef.description = "It's a Gilded dragon pickaxe";
		itemDef.anInt165 = 71;
		itemDef.anInt200 = 71;
		itemDef.modelid = 29;
		itemDef.modelRotationY = 364;
		itemDef.modelRotationX = 1158;
		itemDef.modelZoom = 1382;
		itemDef.modelOffset2 = 8;
		itemDef.modelOffset1 = -12;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Destroy";
		break;
		case 14042://new
		itemDef.name = "Max hood";
		itemDef.description = "It's a Max hood";
		itemDef.anInt165 = 65291;
		itemDef.anInt200 = 65291;
		itemDef.modelid = 65268;
		itemDef.modelRotationY = 11;
		itemDef.modelRotationX = 81;
		itemDef.modelZoom = 760;
		itemDef.modelOffset2 = 1;
		itemDef.modelOffset1 = -3;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Destroy";
		break;
		case 14043://new
		itemDef.name = "Max cape";
		itemDef.description = "It's a Maxcape";
		itemDef.anInt165 = 65300;
		itemDef.anInt200 = 65300;
		itemDef.modelid = 65262;
		itemDef.modelRotationY = 279;
		itemDef.modelRotationX = 948;
		itemDef.modelZoom = 1385;
		itemDef.modelOffset2 = -5;
		itemDef.modelOffset1 = 24;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Destroy";
		break;
		case 14044://new
		itemDef.name = "Classic hood";
		itemDef.description = "It's a Classic hood";
		itemDef.anInt165 = 65290;
		itemDef.anInt200 = 65290;
		itemDef.modelid = 19;
		itemDef.modelRotationY = 11;
		itemDef.modelRotationX = 81;
		itemDef.modelZoom = 760;
		itemDef.modelOffset2 = 1;
		itemDef.modelOffset1 = -3;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Destroy";
		break;
		case 14045://new
		itemDef.name = "Classic cape";
		itemDef.description = "It's a Classic cape";
		itemDef.anInt165 = 65302;
		itemDef.anInt200 = 65302;
		itemDef.modelid = 65257;
		itemDef.modelRotationY = 279;
		itemDef.modelRotationX = 948;
		itemDef.modelZoom = 1513;
		itemDef.modelOffset2 = -3;
		itemDef.modelOffset1 = 24;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Destroy";
		itemDef.editedModelColor = new int[1];
		itemDef.newModelColor = new int[1];
		itemDef.editedModelColor[0] = 0;
		itemDef.newModelColor[0] = 2;
		break;
		case 14046://new
		itemDef.name = "Veteran hood";
		itemDef.description = "It's a Veteran hood";
		itemDef.anInt165 = 65289;
		itemDef.anInt200 = 65289;
		itemDef.modelid = 65271;
		itemDef.modelRotationY = 11;
		itemDef.modelRotationX = 81;
		itemDef.modelZoom = 760;
		itemDef.modelOffset2 = 1;
		itemDef.modelOffset1 = -3;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Destroy";
		itemDef.editedModelColor = new int[1];
		itemDef.newModelColor = new int[1];
		break;
		case 14047://new
		itemDef.name = "Veteran cape";
		itemDef.description = "It's a Veteran cape";
		itemDef.anInt165 = 65305;
		itemDef.anInt200 = 65305;
		itemDef.modelid = 65261;
		itemDef.modelRotationY = 279;
		itemDef.modelRotationX = 948;
		itemDef.modelZoom = 1513;
		itemDef.modelOffset2 = -3;
		itemDef.modelOffset1 = 24;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Destroy";
		itemDef.editedModelColor = new int[1];
		itemDef.newModelColor = new int[1];
		break;
		case 14048://new
		itemDef.name = "Walking stick";
		itemDef.description = "It's a Walking stick";
		itemDef.anInt165 = 21874;
		itemDef.anInt200 = 21874;
		itemDef.modelid = 19975;;
		itemDef.modelRotationY = 148;
		itemDef.modelRotationX = 1400;
		itemDef.modelZoom = 1490;;
		itemDef.modelOffset2 = -6;
		itemDef.modelOffset1 = 2;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Destroy";
		itemDef.editedModelColor = new int[1];
		itemDef.newModelColor = new int[1];
		break;
		case 14049://new
		itemDef.name = "Rambler's backpack";
		itemDef.description = "It's a Rambler's backpack";
		itemDef.anInt165 = 14176;
		itemDef.anInt200 = 14176;
		itemDef.modelid = 20094;
		itemDef.modelRotationY = 229;
		itemDef.modelRotationX = 848;
		itemDef.modelZoom = 921;
		itemDef.modelOffset2 = 0;
		itemDef.modelOffset1 = -3;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Destroy";
		itemDef.editedModelColor = new int[1];
		itemDef.newModelColor = new int[1];
		break;
		case 14050:
		itemDef.name = "Gnome scarf";
		itemDef.modelid = 17125;
		itemDef.editedModelColor = new int [3];
		itemDef.newModelColor = new int [3];
		itemDef.editedModelColor[0] = 119;
		itemDef.newModelColor[0] = 12978;
		itemDef.editedModelColor[1] = 103;
		itemDef.newModelColor[1] = 12978;
		itemDef.editedModelColor[2] = 127;
		itemDef.newModelColor[2] = 12978;
		itemDef.modelZoom = 919;
		itemDef.modelRotationY = 595;
		itemDef.modelRotationX = 0;
		itemDef.modelOffset1 = -7;
		itemDef.modelOffset2 = 8;
		itemDef.anInt165 = 17155;
		itemDef.anInt200 = 17157;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
	break;
		
			case 14018:
				itemDef.modelid = 59914;
				itemDef.name = "Vanguard helm";
				itemDef.modelZoom = 855;
				itemDef.modelRotationX = 5;
				itemDef.modelRotationY = 1966;
				itemDef.modelOffset2 = 4;
				itemDef.modelOffset1 = -1;
				itemDef.stackable = false;
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
				itemDef.anInt200 = 44769;
				itemDef.anInt165 = 44769;
			break;
			case 14019:
				itemDef.modelid = 59921;
				itemDef.name = "Vanguard body";
				itemDef.modelZoom = 1513;
				itemDef.modelRotationX = 2041;
				itemDef.modelRotationY = 593;
				itemDef.modelOffset1 = 3;
				itemDef.modelOffset2 = -11;
				itemDef.stackable = false;
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
				itemDef.anInt200 = 44812;
				itemDef.anInt165 = 44812;
			break;
			case 14020:
				itemDef.modelid = 44658;
				itemDef.name = "Vanguard legs";
				itemDef.modelZoom = 1711;
				itemDef.modelRotationX = 0;
				itemDef.modelRotationY = 360;
				itemDef.modelOffset1 = 3;
				itemDef.modelOffset2 = -11;
				itemDef.stackable = false;
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
				itemDef.anInt200 = 44771;
				itemDef.anInt165 = 44771;
			break;
			case 14021:
				itemDef.modelid = 44699;
				itemDef.name = "Vanguard gloves";
				itemDef.modelZoom = 830;
				itemDef.modelRotationX = 0;
				itemDef.modelRotationY = 536;
				itemDef.modelOffset1 = 9;
				itemDef.modelOffset2 = 3;
				itemDef.stackable = false;
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
				itemDef.anInt200 = 44758;
				itemDef.anInt165 = 44758;
			break;
			case 14022:
				itemDef.modelid = 44700;
				itemDef.name = "Vanguard boots";
				itemDef.modelZoom = 848;
				itemDef.modelRotationX = 141;
				itemDef.modelRotationY = 141;
				itemDef.modelOffset1 = 4;
				itemDef.modelOffset2 = 0;
				itemDef.stackable = false;
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
				itemDef.anInt200 = 44752;
				itemDef.anInt165 = 44752;
			break;
			case 14023:
				itemDef.modelid = 44704;
				itemDef.name = "Battle-mage helm";
				itemDef.modelZoom = 658;
				itemDef.modelRotationX = 1898;
				itemDef.modelRotationY = 2;
				itemDef.modelOffset1 = 12;
				itemDef.modelOffset2 = 3;
				itemDef.stackable = false;
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
				itemDef.anInt200 = 44767;
				itemDef.anInt165 = 44767;
			break;
			case 14024:
				itemDef.modelid = 44631;
				itemDef.name = "Battle-mage robe";
				itemDef.modelZoom = 1382;
				itemDef.modelRotationX = 3;
				itemDef.modelRotationY = 488;
				itemDef.modelOffset1 = 1;
				itemDef.modelOffset2 = 0;
				itemDef.stackable = false;
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
				itemDef.anInt200 = 44818;
				itemDef.anInt165 = 44818;
			break;
			case 14025:
				itemDef.modelid = 44672;
				itemDef.name = "Battle-mage robe legs";
				itemDef.modelZoom = 1842;
				itemDef.modelRotationX = 1024;
				itemDef.modelRotationY = 498;
				itemDef.modelOffset1 = 4;
				itemDef.modelOffset2 = -1;
				itemDef.stackable = false;
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
				itemDef.anInt200 = 44775;
				itemDef.anInt165 = 44775;
			break;
			case 14026:
				itemDef.modelid = 44662;
				itemDef.name = "Battle-mage boots";
				itemDef.modelZoom = 987;
				itemDef.modelRotationX = 1988;
				itemDef.modelRotationY = 188;
				itemDef.modelOffset1 = -8;
				itemDef.modelOffset2 = 5;
				itemDef.stackable = false;
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
				itemDef.anInt200 = 44755;
				itemDef.anInt165 = 44755;
			break;
			case 14027:
				itemDef.modelid = 44573;
				itemDef.name = "Battle-mage gloves";
				itemDef.modelZoom = 1053;
				itemDef.modelRotationX = 0;
				itemDef.modelRotationY = 536;
				itemDef.modelOffset1 = 3;
				itemDef.modelOffset2 = 0;
				itemDef.stackable = false;
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
				itemDef.anInt200 = 44762;
				itemDef.anInt165 = 44762;
			break;

	case 14009:
		itemDef.name = "Gnome scarf";
		itemDef.modelid = 17125;
		itemDef.editedModelColor = new int [3];
		itemDef.newModelColor = new int [3];
		itemDef.editedModelColor[0] = 119;
		itemDef.newModelColor[0] = 7737;
		itemDef.editedModelColor[1] = 103;
		itemDef.newModelColor[1] = 7737;
		itemDef.editedModelColor[2] = 127;
		itemDef.newModelColor[2] = 7737;
		itemDef.modelZoom = 919;
		itemDef.modelRotationY = 595;
		itemDef.modelRotationX = 0;
		itemDef.modelOffset1 = -7;
		itemDef.modelOffset2 = 8;
		itemDef.anInt165 = 17155;
		itemDef.anInt200 = 17157;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
	break;
	case 14010:
		itemDef.name = "Gnome scarf";
		itemDef.modelid = 17125;
		itemDef.editedModelColor = new int [3];
		itemDef.newModelColor = new int [3];
		itemDef.editedModelColor[0] = 119;
		itemDef.newModelColor[0] = 725;
		itemDef.editedModelColor[1] = 103;
		itemDef.newModelColor[1] = 725;
		itemDef.editedModelColor[2] = 127;
		itemDef.newModelColor[2] = 725;
		itemDef.modelZoom = 919;
		itemDef.modelRotationY = 595;
		itemDef.modelRotationX = 0;
		itemDef.modelOffset1 = -7;
		itemDef.modelOffset2 = 8;
		itemDef.anInt165 = 17155;
		itemDef.anInt200 = 17157;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
	break;

	case 14011:
		itemDef.name = "Gnome scarf";
		itemDef.modelid = 17125;
		itemDef.editedModelColor = new int [3];
		itemDef.newModelColor = new int [3];
		itemDef.editedModelColor[0] = 119;
		itemDef.newModelColor[0] = -22250;
		itemDef.editedModelColor[1] = 103;
		itemDef.newModelColor[1] = -22250;
		itemDef.editedModelColor[2] = 127;
		itemDef.newModelColor[2] = -22250;
		itemDef.modelZoom = 919;
		itemDef.modelRotationY = 595;
		itemDef.modelRotationX = 0;
		itemDef.modelOffset1 = -7;
		itemDef.modelOffset2 = 8;
		itemDef.anInt165 = 17155;
		itemDef.anInt200 = 17157;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
	break;

	case 14012:
		itemDef.name = "Gnome scarf";
		itemDef.modelid = 17125;
		itemDef.editedModelColor = new int [3];
		itemDef.newModelColor = new int [3];
		itemDef.editedModelColor[0] = 119;
		itemDef.newModelColor[0] = 23970;
		itemDef.editedModelColor[1] = 103;
		itemDef.newModelColor[1] = 23970;
		itemDef.editedModelColor[2] = 127;
		itemDef.newModelColor[2] = 23970;
		itemDef.modelZoom = 919;
		itemDef.modelRotationY = 595;
		itemDef.modelRotationX = 0;
		itemDef.modelOffset1 = -7;
		itemDef.modelOffset2 = 8;
		itemDef.anInt165 = 17155;
		itemDef.anInt200 = 17157;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
	break;
	
	case 14006:
		itemDef.name = "Robin hood hat";
		itemDef.modelid = 3021;
		itemDef.editedModelColor = new int [3];
		itemDef.newModelColor = new int [3];
		itemDef.editedModelColor[0] = 15009;
		itemDef.newModelColor[0] = 30847;
		itemDef.editedModelColor[1] = 17294;
		itemDef.newModelColor[1] = 32895;
		itemDef.editedModelColor[2] = 15252;
		itemDef.newModelColor[2] = 30847;
		itemDef.modelZoom = 650;
		itemDef.modelRotationY = 2044;
		itemDef.modelRotationX = 256;
		itemDef.modelOffset1 = -3;
		itemDef.modelOffset2 = -2;
		itemDef.anInt165 = 3378;
		itemDef.anInt200 = 3382;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
	break;

	case 14007:
		itemDef.name = "Robin hood hat";
		itemDef.modelid = 3021;
		itemDef.editedModelColor = new int [3];
		itemDef.newModelColor = new int [3];
		itemDef.editedModelColor[0] = 15009;
		itemDef.newModelColor[0] = 10015;
		itemDef.editedModelColor[1] = 17294;
		itemDef.newModelColor[1] = 7730;
		itemDef.editedModelColor[2] = 15252;
		itemDef.newModelColor[2] = 7973;
		itemDef.modelZoom = 650;
		itemDef.modelRotationY = 2044;
		itemDef.modelRotationX = 256;
		itemDef.modelOffset1 = -3;
		itemDef.modelOffset2 = -2;
		itemDef.anInt165 = 3378;
		itemDef.anInt200 = 3382;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
	break;

	case 14008:
		itemDef.name = "Robin hood hat";
		itemDef.modelid = 3021;
		itemDef.editedModelColor = new int [3];
		itemDef.newModelColor = new int [3];
		itemDef.editedModelColor[0] = 15009;
		itemDef.newModelColor[0] = 35489;
		itemDef.editedModelColor[1] = 17294;
		itemDef.newModelColor[1] = 37774;
		itemDef.editedModelColor[2] = 15252;
		itemDef.newModelColor[2] = 35732;
		itemDef.modelZoom = 650;
		itemDef.modelRotationY = 2044;
		itemDef.modelRotationX = 256;
		itemDef.modelOffset1 = -3;
		itemDef.modelOffset2 = -2;
		itemDef.anInt165 = 3378;
		itemDef.anInt200 = 3382;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
	break;
		case 20301:
		itemDef.modelid = 28;
		itemDef.name = "Golden mining gloves";
		itemDef.modelZoom = 1049;
		itemDef.modelRotationX = 377;
		itemDef.modelRotationY = 970;
		itemDef.modelOffset1 = -1;
		itemDef.modelOffset2 = -1;
		itemDef.anInt165 = 47;
		itemDef.anInt200 = 58;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Drop";
	break;
	case 20302:
		itemDef.modelid = 27;
		itemDef.name = "Golden mining boots";
		itemDef.modelZoom = 848;
		itemDef.modelRotationX = 177;
		itemDef.modelRotationY = 195;
		itemDef.modelOffset1 = 7;
		itemDef.modelOffset2 = -20;
		itemDef.anInt165 = 46;
		itemDef.anInt200 = 57;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Drop";
	break;
	case 20303:
		itemDef.modelid = 24;
		itemDef.name = "Golden mining helmet";
		itemDef.modelZoom = 976;
		itemDef.modelRotationX = 132;
		itemDef.modelRotationY = 165;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = 0;
		itemDef.anInt165 = 48;
		itemDef.anInt200 = 59;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Check-charges";
		itemDef.itemActions[4] = "Drop";
	break;
	case 20304:
		itemDef.modelid = 23;
		itemDef.name = "Golden mining trousers";
		itemDef.modelZoom = 1616;
		itemDef.modelRotationX = 276;
		itemDef.modelRotationY = 1829;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = 11;
		itemDef.anInt165 = 50;
		itemDef.anInt200 = 61;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Check-charges";
		itemDef.itemActions[4] = "Drop";
	break;
	case 20305:
		itemDef.modelid = 31;
		itemDef.name = "Golden mining top";
		itemDef.modelZoom = 1360;
		itemDef.modelRotationX = 609;
		itemDef.modelRotationY = 0;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = -1;
		itemDef.anInt165 = 54;
		itemDef.anInt200 = 64;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Check-charges";
		itemDef.itemActions[4] = "Drop";
	break;
	
	
	case 20300:
		itemDef.modelid = 15611;
		itemDef.name = "Hylise race helmet";
		itemDef.description = "A custom helmet, specially designed for the females in TheNewScapers";
		itemDef.modelZoom = 1122;
		itemDef.modelRotationY = 474;
		itemDef.modelRotationX = 2045;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = -5;
		itemDef.anInt165 = 15609;
		itemDef.anInt200 = 15609;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Check-charges";
		itemDef.itemActions[4] = "Drop";
	break;

case 19755:
		itemDef.name = "Attack XP lamp";
		itemDef.description = "Rubbing this lamp will provide me of some Attack Experience.";
		itemDef.itemActions[4] = "Drop";
	break;

case 19758:
		itemDef.name = "Strength XP lamp";
		itemDef.description = "Rubbing this lamp will provide me of some Strength Experience.";
		itemDef.itemActions[4] = "Drop";
	break;

case 19764:
		itemDef.name = "Defence XP lamp";
		itemDef.description = "Rubbing this lamp will provide me of some Defence Experience.";
		itemDef.itemActions[4] = "Drop";
	break;

case 19767:
		itemDef.name = "Hitpoints XP lamp";
		itemDef.description = "Rubbing this lamp will provide me of some Hitpoints Experience.";
		itemDef.itemActions[4] = "Drop";
	break;

case 19750:
		itemDef.name = "Ranging XP lamp";
		itemDef.description = "Rubbing this lamp will provide me of some Ranging Experience.";
		itemDef.itemActions[4] = "Drop";
	break;
	
	case 10831:
		itemDef.name = "Empty money bag";
		itemDef.itemActions[0] = "Fill bag";
		itemDef.description = "If i had either 100m, 500m, 1b, or maybe even 2b, i could put it in this bag.";
		itemDef.itemActions[4] = "Drop";
	break;
	
		case 10835:
		itemDef.name = "Full money bag";
		itemDef.itemActions[0] = "Empty bag";
		itemDef.description = "This bag means i own 2,000,000,000 GP, sounds really nice!";
		itemDef.itemActions[4] = "Drop";
	break;
	
		case 10834:
		itemDef.name = "Hefty money bag";
		itemDef.itemActions[0] = "Empty bag";
		itemDef.description = "This bag means i own 1,000,000,000 GP, sounds nice!";
		itemDef.itemActions[4] = "Drop";
	break;
	
	case 10833:
		itemDef.name = "Normal money bag";
		itemDef.itemActions[0] = "Empty bag";
		itemDef.description = "This bag means i own 500,000,000 GP, sounds nice i guess..";
		itemDef.itemActions[4] = "Drop";
	break;
	
	case 10832:
		itemDef.name = "Light money bag";
		itemDef.itemActions[0] = "Empty bag";
		itemDef.description = "This bag means i own 100,000,000 GP, not a lot.. but still nice..";
		itemDef.itemActions[4] = "Drop";
	break;
	

case 19775:
		itemDef.name = "Magic XP lamp";
		itemDef.description = "Rubbing this lamp will provide me of some Magic Experience.";
		itemDef.itemActions[4] = "Drop";
	break;

case 19752:
		itemDef.name = "Prayer XP lamp";
		itemDef.description = "Rubbing this lamp will provide me of some Prayer Experience.";
		itemDef.itemActions[4] = "Drop";
	break;
	
	case 11838:
			itemDef.itemActions[0] = "Open";
	break;

	case 13358:
		itemDef.modelid = 62699;
		itemDef.name = "Torva platebody";
		itemDef.description = "Torva Platebody.";
		itemDef.modelZoom = 1506;
		itemDef.modelRotationY = 473;
		itemDef.modelRotationX = 2042;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = 0;
		itemDef.anInt165 = 62746;
		itemDef.anInt200 = 62762;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Check-charges";
		itemDef.itemActions[4] = "Drop";
	break;
			case 13355:
			itemDef.modelid = 62693;
			itemDef.name = "Pernix cowl";
			itemDef.description = "Pernix cowl";
			itemDef.modelZoom = 800;
			itemDef.modelRotationY = 532;
			itemDef.modelRotationX = 14;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 62739;
			itemDef.anInt200 = 62756;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.itemActions = new String[5];
			itemDef.itemActions[1] = "Wear";
			itemDef.itemActions[2] = "Check-charges";
			itemDef.itemActions[4] = "Drop";
			itemDef.anInt175 = 62731;
			itemDef.anInt197 = 62727;
			itemDef.editedModelColor = new int[1];
		itemDef.newModelColor = new int[1];
		itemDef.editedModelColor[0] = 0;
		itemDef.newModelColor[0] = 51;
			break;
			
			
			

	case 13354:
		itemDef.modelid = 62709;
		itemDef.name = "Pernix body";
		itemDef.description = "Pernix body";
		itemDef.modelZoom = 1378;
		itemDef.modelRotationY = 485;
		itemDef.modelRotationX = 2042;
		itemDef.modelOffset1 = -1;
		itemDef.modelOffset2 = 7;
		itemDef.anInt165 = 62744;
		itemDef.anInt200 = 62765;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Check-charges";
		itemDef.itemActions[4] = "Drop";
	break;
	
	
	case 14001:
		itemDef.name = "Staff of light";
		itemDef.modelid = 51845;
		itemDef.editedModelColor = new int [11];
		itemDef.newModelColor = new int [11];
		itemDef.editedModelColor[0] = 7860;
		itemDef.newModelColor[0] = 38310;
		itemDef.editedModelColor[1] = 7876;
		itemDef.newModelColor[1] = 38310;
		itemDef.editedModelColor[2] = 7892;
		itemDef.newModelColor[2] = 38310;
		itemDef.editedModelColor[3] = 7884;
		itemDef.newModelColor[3] = 38310;
		itemDef.editedModelColor[4] = 7868;
		itemDef.newModelColor[4] = 38310;
		itemDef.editedModelColor[5] = 7864;
		itemDef.newModelColor[5] = 38310;
		itemDef.editedModelColor[6] = 7880;
		itemDef.newModelColor[6] = 38310;
		itemDef.editedModelColor[7] = 7848;
		itemDef.newModelColor[7] = 38310;
		itemDef.editedModelColor[8] = 7888;
		itemDef.newModelColor[8] = 38310;
		itemDef.editedModelColor[9] = 7872;
		itemDef.newModelColor[9] = 38310;
		itemDef.editedModelColor[10] = 7856;
		itemDef.newModelColor[10] = 38310;
		itemDef.modelZoom = 2256;
		itemDef.modelRotationY = 456;
		itemDef.modelRotationX = 513;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = 0;
		itemDef.anInt165 = 51795;
		itemDef.anInt200 = 51795;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wield";
	break;

	case 14002:
		itemDef.name = "Staff of light";
		itemDef.modelid = 51845;
		itemDef.editedModelColor = new int [11];
		itemDef.newModelColor = new int [11];
		itemDef.editedModelColor[0] = 7860;
		itemDef.newModelColor[0] = 432;
		itemDef.editedModelColor[1] = 7876;
		itemDef.newModelColor[1] = 432;
		itemDef.editedModelColor[2] = 7892;
		itemDef.newModelColor[2] = 432;
		itemDef.editedModelColor[3] = 7884;
		itemDef.newModelColor[3] = 432;
		itemDef.editedModelColor[4] = 7868;
		itemDef.newModelColor[4] = 432;
		itemDef.editedModelColor[5] = 7864;
		itemDef.newModelColor[5] = 432;
		itemDef.editedModelColor[6] = 7880;
		itemDef.newModelColor[6] = 432;
		itemDef.editedModelColor[7] = 7848;
		itemDef.newModelColor[7] = 432;
		itemDef.editedModelColor[8] = 7888;
		itemDef.newModelColor[8] = 432;
		itemDef.editedModelColor[9] = 7872;
		itemDef.newModelColor[9] = 432;
		itemDef.editedModelColor[10] = 7856;
		itemDef.newModelColor[10] = 432;
		itemDef.modelZoom = 2256;
		itemDef.modelRotationY = 456;
		itemDef.modelRotationX = 513;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = 0;
		itemDef.anInt165 = 51795;
		itemDef.anInt200 = 51795;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wield";
	break;

	case 14003:
		itemDef.name = "Staff of light";
		itemDef.modelid = 51845;
		itemDef.editedModelColor = new int [11];
		itemDef.newModelColor = new int [11];
		itemDef.editedModelColor[0] = 7860;
		itemDef.newModelColor[0] = 24006;
		itemDef.editedModelColor[1] = 7876;
		itemDef.newModelColor[1] = 24006;
		itemDef.editedModelColor[2] = 7892;
		itemDef.newModelColor[2] = 24006;
		itemDef.editedModelColor[3] = 7884;
		itemDef.newModelColor[3] = 24006;
		itemDef.editedModelColor[4] = 7868;
		itemDef.newModelColor[4] = 24006;
		itemDef.editedModelColor[5] = 7864;
		itemDef.newModelColor[5] = 24006;
		itemDef.editedModelColor[6] = 7880;
		itemDef.newModelColor[6] = 24006;
		itemDef.editedModelColor[7] = 7848;
		itemDef.newModelColor[7] = 24006;
		itemDef.editedModelColor[8] = 7888;
		itemDef.newModelColor[8] = 24006;
		itemDef.editedModelColor[9] = 7872;
		itemDef.newModelColor[9] = 24006;
		itemDef.editedModelColor[10] = 7856;
		itemDef.newModelColor[10] = 24006;
		itemDef.modelZoom = 2256;
		itemDef.modelRotationY = 456;
		itemDef.modelRotationX = 513;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = 0;
		itemDef.anInt165 = 51795;
		itemDef.anInt200 = 51795;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wield";
	break;

	case 14004:
		itemDef.name = "Staff of light";
		itemDef.modelid = 51845;
		itemDef.editedModelColor = new int [11];
		itemDef.newModelColor = new int [11];
		itemDef.editedModelColor[0] = 7860;
		itemDef.newModelColor[0] = 14285;
		itemDef.editedModelColor[1] = 7876;
		itemDef.newModelColor[1] = 14285;
		itemDef.editedModelColor[2] = 7892;
		itemDef.newModelColor[2] = 14285;
		itemDef.editedModelColor[3] = 7884;
		itemDef.newModelColor[3] = 14285;
		itemDef.editedModelColor[4] = 7868;
		itemDef.newModelColor[4] = 14285;
		itemDef.editedModelColor[5] = 7864;
		itemDef.newModelColor[5] = 14285;
		itemDef.editedModelColor[6] = 7880;
		itemDef.newModelColor[6] = 14285;
		itemDef.editedModelColor[7] = 7848;
		itemDef.newModelColor[7] = 14285;
		itemDef.editedModelColor[8] = 7888;
		itemDef.newModelColor[8] = 14285;
		itemDef.editedModelColor[9] = 7872;
		itemDef.newModelColor[9] = 14285;
		itemDef.editedModelColor[10] = 7856;
		itemDef.newModelColor[10] = 14285;
		itemDef.modelZoom = 2256;
		itemDef.modelRotationY = 456;
		itemDef.modelRotationX = 513;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = 0;
		itemDef.anInt165 = 51795;
		itemDef.anInt200 = 51795;
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wield";
	break;

	case 15441:
		itemDef.name = "Abyssal whip";
		itemDef.description = "A weapon from the abyss.";
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Split";
		itemDef.itemActions[4] = "Drop";
	break;

	case 15442:
		itemDef.name = "Abyssal whip";
		itemDef.description = "A weapon from the abyss.";
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Split";
		itemDef.itemActions[4] = "Drop";
	break;



	case 15443:
		itemDef.name = "Abyssal whip";
		itemDef.description = "A weapon from the abyss.";
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Split";
		itemDef.itemActions[4] = "Drop";
	break;

	case 15444:
		itemDef.name = "Abyssal whip";
		itemDef.description = "A weapon from the abyss.";
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Split";
		itemDef.itemActions[4] = "Drop";
	break;

	case 13352:
		itemDef.modelid = 62695;
		itemDef.name = "Pernix chaps";
		itemDef.description = "Pernix chaps";
		itemDef.modelZoom = 1740;
		itemDef.modelRotationY = 504;
		itemDef.modelRotationX = 0;
		itemDef.modelOffset1 = 4;
		itemDef.modelOffset2 = 3;
		itemDef.anInt165 = 62741;
		itemDef.anInt200 = 62757;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Check-charges";
		itemDef.itemActions[4] = "Drop";
	break;

	case 13350:
		itemDef.modelid = 62710;
		itemDef.name = "Virtus mask";
		itemDef.description = "Virtus mask";
		itemDef.modelZoom = 928;
		itemDef.modelRotationY = 406;
		itemDef.modelRotationX = 2041;
		itemDef.modelOffset1 = 1;
		itemDef.modelOffset2 = -5;
		itemDef.anInt165 = 62736;
		itemDef.anInt200 = 62755;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Check-charges";
		itemDef.itemActions[4] = "Drop";
		itemDef.anInt175 = 62728;
		itemDef.anInt197 = 62728;
	break;

	case 13348:
		itemDef.modelid = 62704;
		itemDef.name = "Virtus robe top";
		itemDef.description = "Virtus robe top";
		itemDef.modelZoom = 1122;
		itemDef.modelRotationY = 488;
		itemDef.modelRotationX = 3;
		itemDef.modelOffset1 = 1;
		itemDef.modelOffset2 = 0;
		itemDef.anInt165 = 62748;
		itemDef.anInt200 = 62764;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Check-charges";
		itemDef.itemActions[4] = "Drop";
	break;

	case 13346:
		itemDef.modelid = 62700;
		itemDef.name = "Virtus robe legs";
		itemDef.description = "Virtus robe legs";
		itemDef.modelZoom = 1740;
		itemDef.modelRotationY = 498;
		itemDef.modelRotationX = 2045;
		itemDef.modelOffset1 = -1;
		itemDef.modelOffset2 = 4;
		itemDef.anInt165 = 62742;
		itemDef.anInt200 = 62758;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[2] = "Check-charges";
		itemDef.itemActions[4] = "Drop";
	break;
	case 13344:
		itemDef.modelid = 62694;
		itemDef.name = "Ancient ceremonial hood";
		itemDef.modelZoom = 980;
		itemDef.modelRotationY = 208;
		itemDef.modelRotationX = 220;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = -18;
		itemDef.anInt165 = 62737;
		itemDef.anInt200 = 62753;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Drop";
		itemDef.anInt175 = 62730;
		itemDef.anInt197 = 62730;
	break;

	case 13342:
		itemDef.modelid = 62705;
		itemDef.name = "Ancient ceremonial top";
		itemDef.modelZoom = 1316;
		itemDef.modelRotationY = 477;
		itemDef.modelRotationX = 9;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = 13;
		itemDef.anInt165 = 62745;
		itemDef.anInt200 = 62763;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Drop";
		itemDef.anInt204 = 54;
	break;

	case 13340:
		itemDef.modelid = 62707;
		itemDef.name = "Ancient ceremonial legs";
		itemDef.modelZoom = 1828;
		itemDef.modelRotationY = 539;
		itemDef.modelRotationX = 0;
		itemDef.modelOffset1 = -1;
		itemDef.modelOffset2 = 0;
		itemDef.anInt165 = 62740;
		itemDef.anInt200 = 62759;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Drop";
		itemDef.anInt204 = 40;
		itemDef.anInt196 = 30;
		itemDef.anInt184 = 100;
	break;

		case 14000:
		itemDef.modelid = 39029;
		itemDef.name = "Spercane shield";
		itemDef.modelZoom = 1488;
		itemDef.modelRotationY = 396;
		itemDef.modelRotationX = 1050;
		itemDef.modelOffset1 = -3;
		itemDef.modelOffset2 = 4;
		itemDef.anInt165 = 39029;
		itemDef.anInt200 = 39029;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Drop";
	break;
	
			case 20306:
		itemDef.modelid = 13717;
		itemDef.name = "Hylian shield";
		itemDef.description = "A custom shield, specially designed for the females in TheNewScapers.";
		itemDef.modelZoom = 1560;
		itemDef.modelRotationY = 500;
		itemDef.modelRotationX = 500;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = 0;
		itemDef.anInt165 = 13718;
		itemDef.anInt200 = 13719;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Drop";
	break;
	
				case 20307:
		itemDef.modelid = 666;
		itemDef.name = "Essence blade";
		itemDef.description = "A custom blade, specially designed for.. people..";
		itemDef.modelZoom = 1560;
		itemDef.modelRotationY = 800;
		itemDef.modelRotationX = 540;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = 0;
		itemDef.anInt165 = 667;
		itemDef.anInt200 = 667;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Drop";
	break;
	
					case 20308:
		itemDef.modelid = 50570;
		itemDef.name = "Blue lightsaber";
		itemDef.description = "A custom sword, specially made for TheNewScapers fans.";
		itemDef.modelZoom = 1560;
		itemDef.modelRotationY = 800;
		itemDef.modelRotationX = 540;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = 0;
		itemDef.anInt165 = 50571;
		itemDef.anInt200 = 50571;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Drop";
	break;
	
	
	case 13370:
		itemDef.modelid = 62697;
		itemDef.name = "Ancient ceremonial gloves";
		itemDef.modelZoom = 548;
		itemDef.modelRotationY = 618;
		itemDef.modelRotationX = 1143;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = -5;
		itemDef.anInt165 = 62735;
		itemDef.anInt200 = 62752;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Drop";
	break;

	case 13336:
		itemDef.modelid = 62696;
		itemDef.name = "Ancient ceremonial boots";
		itemDef.modelZoom = 676;
		itemDef.modelRotationY = 63;
		itemDef.modelRotationX = 106;
		itemDef.modelOffset1 = 5;
		itemDef.modelOffset2 = -1;
		itemDef.anInt165 = 62734;
		itemDef.anInt200 = 62751;
		itemDef.groundActions = new String[5];
		itemDef.groundActions[2] = "Take";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.itemActions[4] = "Drop";
	break;

}
		return itemDef;
	}
	
	public static void unpackConfig(NamedArchive streamLoader) {
		stream = new Stream(FileOperations.ReadFile(signlink.findcachedir() + "obj.dat"));
		Stream stream = new Stream(FileOperations.ReadFile(signlink.findcachedir() + "obj.idx"));
		totalItems = stream.readUnsignedWord();
		streamIndices = new int[totalItems + 5000];
		int i = 2;
		for (int j = 0; j < totalItems; j++) {
			streamIndices[j] = i;
			i += stream.readUnsignedWord();
		}
		cache = new ItemDef[10];
		for (int k = 0; k < 10; k++)
			cache[k] = new ItemDef();
	}

	public void setDefaults() {
		modelid = 0;
		name = null;
		description = null;
		editedModelColor = null;
		newModelColor = null;
		modelZoom = 2000;
		modelRotationY = 0;
		modelRotationX = 0;
		anInt204 = 0;
		modelOffset1 = 0;
		modelOffset2 = 0;
		stackable = false;
		value = 1;
		membersObject = false;
		groundActions = null;
		itemActions = null;
		anInt165 = -1;
		anInt188 = -1;
		aByte205 = 0;
		anInt200 = -1;
		anInt164 = -1;
		aByte154 = 0;
		anInt185 = -1;
		anInt162 = -1;
		anInt175 = -1;
		anInt166 = -1;
		anInt197 = -1;
		anInt173 = -1;
		stackIDs = null;
		stackAmounts = null;
		certID = -1;
		certTemplateID = -1;
		anInt167 = 128;
		anInt192 = 128;
		anInt191 = 128;
		anInt196 = 0;
		anInt184 = 0;
		team = 0;
		lendID = -1;
		lentItemID = -1;
	}
	
	public void readValues(Stream stream) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0)
				return;
			if (i == 1) {
				modelid = stream.readUnsignedWord();
			} else if (i == 2)
				name = stream.readString();
			else if (i == 3)
				description = stream.readString();
			else if (i == 4)
				modelZoom = stream.readUnsignedWord();
			else if (i == 5)
				modelRotationY = stream.readUnsignedWord();
			else if (i == 6)
				modelRotationX = stream.readUnsignedWord();
			else if (i == 7) {
				modelOffset1 = stream.readUnsignedWord();
				if (modelOffset1 > 32767)
					modelOffset1 -= 0x10000;
			} else if (i == 8) {
				modelOffset2 = stream.readUnsignedWord();
				if (modelOffset2 > 32767)
					modelOffset2 -= 0x10000;
			} else if (i == 10)
				stream.readUnsignedWord();
			else if (i == 11)
				stackable = true;
			else if (i == 12)
				value = stream.readUnsignedWord();
			else if (i == 16)
				membersObject = true;
			else if (i == 23) {
				anInt165 = stream.readUnsignedWord();
				aByte205 = stream.readSignedByte();
			} else if (i == 24)
				anInt188 = stream.readUnsignedWord();
			else if (i == 25) {
				anInt200 = stream.readUnsignedWord();
				aByte154 = stream.readSignedByte();
			} else if (i == 26)
				anInt164 = stream.readUnsignedWord();
			else if (i >= 30 && i < 35) {
				if (groundActions == null)
					groundActions = new String[5];
				groundActions[i - 30] = stream.readString();
				if (groundActions[i - 30].equalsIgnoreCase("hidden"))
					groundActions[i - 30] = null;
			} else if (i >= 35 && i < 40) {
				if (itemActions == null)
					itemActions = new String[5];
				itemActions[i - 35] = stream.readString();
				if (itemActions[i - 35].equalsIgnoreCase("null"))
					itemActions[i - 35] = null;
			} else if (i == 40) {
				int j = stream.readUnsignedByte();
				editedModelColor = new int[j];
				newModelColor = new int[j];
				for (int k = 0; k < j; k++) {
					editedModelColor[k] = stream.readUnsignedWord();
					newModelColor[k] = stream.readUnsignedWord();
				}
			} else if (i == 78)
				anInt185 = stream.readUnsignedWord();
			else if (i == 79)
				anInt162 = stream.readUnsignedWord();
			else if (i == 90)
				anInt175 = stream.readUnsignedWord();
			else if (i == 91)
				anInt197 = stream.readUnsignedWord();
			else if (i == 92)
				anInt166 = stream.readUnsignedWord();
			else if (i == 93)
				anInt173 = stream.readUnsignedWord();
			else if (i == 95)
				anInt204 = stream.readUnsignedWord();
			else if (i == 97)
				certID = stream.readUnsignedWord();
			else if (i == 98)
				certTemplateID = stream.readUnsignedWord();
			else if (i >= 100 && i < 110) {
				if (stackIDs == null) {
					stackIDs = new int[10];
					stackAmounts = new int[10];
				}
				stackIDs[i - 100] = stream.readUnsignedWord();
				stackAmounts[i - 100] = stream.readUnsignedWord();
			} else if (i == 110)
				anInt167 = stream.readUnsignedWord();
			else if (i == 111)
				anInt192 = stream.readUnsignedWord();
			else if (i == 112)
				anInt191 = stream.readUnsignedWord();
			else if (i == 113)
				anInt196 = stream.readSignedByte();
			else if (i == 114)
				anInt184 = stream.readSignedByte() * 5;
			else if (i == 115)
				team = stream.readUnsignedByte();
			else if (i == 116)
				lendID = stream.readUnsignedWord();
			else if (i == 117)
				lentItemID = stream.readUnsignedWord();
		} while (true);
	}
	
	public static void nullLoader() {
		mruNodes2 = null;
		mruNodes1 = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	public boolean method192(int j) {
		int k = anInt175;
		int l = anInt166;
		if (j == 1) {
			k = anInt197;
			l = anInt173;
		}
		if (k == -1)
			return true;
		boolean flag = true;
		if (!Model.method463(k))
			flag = false;
		if (l != -1 && !Model.method463(l))
			flag = false;
		return flag;
	}

	public Model method194(int j) {
		int k = anInt175;
		int l = anInt166;
		if (j == 1) {
			k = anInt197;
			l = anInt173;
		}
		if (k == -1)
			return null;
		Model model = Model.method462(k);
		if (l != -1) {
			Model model_1 = Model.method462(l);
			Model models[] = { model, model_1 };
			model = new Model(2, models);
		}
		if (editedModelColor != null) {
			for (int i1 = 0; i1 < editedModelColor.length; i1++)
				model.method476(editedModelColor[i1], newModelColor[i1]);
		}
		return model;
	}

	public boolean method195(int j) {
		int k = anInt165;
		int l = anInt188;
		int i1 = anInt185;
		if (j == 1) {
			k = anInt200;
			l = anInt164;
			i1 = anInt162;
		}
		if (k == -1)
			return true;
		boolean flag = true;
		if (!Model.method463(k))
			flag = false;
		if (l != -1 && !Model.method463(l))
			flag = false;
		if (i1 != -1 && !Model.method463(i1))
			flag = false;
		return flag;
	}

	public Model method196(int i) {
		int j = anInt165;
		int k = anInt188;
		int l = anInt185;
		if (i == 1) {
			j = anInt200;
			k = anInt164;
			l = anInt162;
		}
		if (j == -1)
			return null;
		Model model = Model.method462(j);
		if (k != -1)
			if (l != -1) {
				Model model_1 = Model.method462(k);
				Model model_3 = Model.method462(l);
				Model model_1s[] = { model, model_1, model_3 };
				model = new Model(3, model_1s);
			} else {
				Model model_2 = Model.method462(k);
				Model models[] = { model, model_2 };
				model = new Model(2, models);
			}
		if (i == 0 && aByte205 != 0)
			model.method475(0, aByte205, 0);
		if (i == 1 && aByte154 != 0)
			model.method475(0, aByte154, 0);
		if (editedModelColor != null) {
			for (int i1 = 0; i1 < editedModelColor.length; i1++)
				model.method476(editedModelColor[i1], newModelColor[i1]);
		}
		return model;
	}
	
	public void toNote() {
		ItemDef itemDef = forID(certTemplateID);
		modelid = itemDef.modelid;
		modelZoom = itemDef.modelZoom;
		modelRotationY = itemDef.modelRotationY;
		modelRotationX = itemDef.modelRotationX;
		anInt204 = itemDef.anInt204;
		modelOffset1 = itemDef.modelOffset1;
		modelOffset2 = itemDef.modelOffset2;
		editedModelColor = itemDef.editedModelColor;
		newModelColor = itemDef.newModelColor;
		ItemDef itemDef_1 = forID(certID);
		name = itemDef_1.name;
		membersObject = itemDef_1.membersObject;
		value = itemDef_1.value;
		String s = "a";
		char c = itemDef_1.name.charAt(0);
		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
			s = "an";
		description = ("Swap this note at any bank for " + s + " " + itemDef_1.name + ".");
		stackable = true;
	}
	
	public void toLend() {
		ItemDef itemDef = forID(lentItemID);
		itemActions = new String[5];
		modelid = itemDef.modelid;
		modelOffset1 = itemDef.modelOffset1;
		modelRotationX = itemDef.modelRotationX;
		modelOffset2 = itemDef.modelOffset2;
		modelZoom = itemDef.modelZoom;
		modelRotationY = itemDef.modelRotationY;
		anInt204 = itemDef.anInt204;
		value = 0;
		ItemDef itemDef_1 = forID(lendID);
		anInt166 = itemDef_1.anInt166;
		editedModelColor = itemDef_1.editedModelColor;
		anInt185 = itemDef_1.anInt185;
		anInt188 = itemDef_1.anInt188;
		anInt173 = itemDef_1.anInt173;
		anInt175 = itemDef_1.anInt175;
		groundActions = itemDef_1.groundActions;
		anInt165 = itemDef_1.anInt165;
		name = itemDef_1.name;
		anInt200 = itemDef_1.anInt200;
		membersObject = itemDef_1.membersObject;
		anInt197 = itemDef_1.anInt197;
		anInt164 = itemDef_1.anInt164;
		anInt162 = itemDef_1.anInt162;
		newModelColor = itemDef_1.newModelColor;
		team = itemDef_1.team;
		if (itemDef_1.itemActions != null) {
			for (int i_33_ = 0; i_33_ < 4; i_33_++)
				itemActions[i_33_] = itemDef_1.itemActions[i_33_];
		}
		itemActions[4] = "Discard";
	}

	public static Sprite getSprite(int i, int j, int k) {
		if (k == 0) {
			Sprite sprite = (Sprite) mruNodes1.insertFromCache(i);
			if (sprite != null && sprite.maxHeight != j && sprite.maxHeight != -1) {
				sprite.unlink();
				sprite = null;
			}
			if (sprite != null)
				return sprite;
		}
		ItemDef itemDef = forID(i);
		if (itemDef.stackIDs == null)
			j = -1;
		if (j > 1) {
			int i1 = -1;
			for (int j1 = 0; j1 < 10; j1++)
				if (j >= itemDef.stackAmounts[j1] && itemDef.stackAmounts[j1] != 0)
					i1 = itemDef.stackIDs[j1];
			if (i1 != -1)
				itemDef = forID(i1);
		}
		Model model = itemDef.method201(1);
		if (model == null)
			return null;
		Sprite sprite = null;
		if (itemDef.certTemplateID != -1) {
			sprite = getSprite(itemDef.certID, 10, -1);
			if (sprite == null)
				return null;
		}
		if (itemDef.lentItemID != -1) {
			sprite = getSprite(itemDef.lendID, 50, 0);
			if (sprite == null)
				return null;
		}
		Sprite sprite2 = new Sprite(32, 32);
		int k1 = Texture.textureInt1;
		int l1 = Texture.textureInt2;
		int ai[] = Texture.anIntArray1472;
		int ai1[] = DrawingArea.pixels;
		int i2 = DrawingArea.width;
		int j2 = DrawingArea.height;
		int k2 = DrawingArea.topX;
		int l2 = DrawingArea.bottomX;
		int i3 = DrawingArea.topY;
		int j3 = DrawingArea.bottomY;
		Texture.aBoolean1464 = false;
		DrawingArea.initDrawingArea(32, 32, sprite2.myPixels);
		DrawingArea.drawPixels(32, 0, 0, 0, 32);
		Texture.method364();
		int k3 = itemDef.modelZoom;
		if (k == -1)
			k3 = (int) ((double) k3 * 1.5D);
		if (k > 0)
			k3 = (int) ((double) k3 * 1.04D);
		int l3 = Texture.anIntArray1470[itemDef.modelRotationY] * k3 >> 16;
		int i4 = Texture.anIntArray1471[itemDef.modelRotationY] * k3 >> 16;
		model.method482(itemDef.modelRotationX, itemDef.anInt204, itemDef.modelRotationY, itemDef.modelOffset1, l3 + model.modelHeight / 2 + itemDef.modelOffset2, i4 + itemDef.modelOffset2);
		for (int i5 = 31; i5 >= 0; i5--) {
			for (int j4 = 31; j4 >= 0; j4--)
				if (sprite2.myPixels[i5 + j4 * 32] == 0)
					if (i5 > 0 && sprite2.myPixels[(i5 - 1) + j4 * 32] > 1)
						sprite2.myPixels[i5 + j4 * 32] = 1;
					else if (j4 > 0 && sprite2.myPixels[i5 + (j4 - 1) * 32] > 1)
						sprite2.myPixels[i5 + j4 * 32] = 1;
					else if (i5 < 31 && sprite2.myPixels[i5 + 1 + j4 * 32] > 1)
						sprite2.myPixels[i5 + j4 * 32] = 1;
					else if (j4 < 31 && sprite2.myPixels[i5 + (j4 + 1) * 32] > 1)
						sprite2.myPixels[i5 + j4 * 32] = 1;
		}
		if (k > 0) {
			for (int j5 = 31; j5 >= 0; j5--) {
				for (int k4 = 31; k4 >= 0; k4--)
					if (sprite2.myPixels[j5 + k4 * 32] == 0)
						if (j5 > 0 && sprite2.myPixels[(j5 - 1) + k4 * 32] == 1)
							sprite2.myPixels[j5 + k4 * 32] = k;
						else if (k4 > 0 && sprite2.myPixels[j5 + (k4 - 1) * 32] == 1)
							sprite2.myPixels[j5 + k4 * 32] = k;
						else if (j5 < 31 && sprite2.myPixels[j5 + 1 + k4 * 32] == 1)
							sprite2.myPixels[j5 + k4 * 32] = k;
						else if (k4 < 31 && sprite2.myPixels[j5 + (k4 + 1) * 32] == 1)
							sprite2.myPixels[j5 + k4 * 32] = k;
			}
		} else if (k == 0) {
			for (int k5 = 31; k5 >= 0; k5--) {
				for (int l4 = 31; l4 >= 0; l4--)
					if (sprite2.myPixels[k5 + l4 * 32] == 0 && k5 > 0 && l4 > 0 && sprite2.myPixels[(k5 - 1) + (l4 - 1) * 32] > 0)
						sprite2.myPixels[k5 + l4 * 32] = 0x302020;
			}
		}
		if (itemDef.certTemplateID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}
		if (itemDef.lentItemID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}
		if (k == 0)
			mruNodes1.removeFromCache(sprite2, i);
		DrawingArea.initDrawingArea(j2, i2, ai1);
		DrawingArea.setDrawingArea(j3, k2, l2, i3);
		Texture.textureInt1 = k1;
		Texture.textureInt2 = l1;
		Texture.anIntArray1472 = ai;
		Texture.aBoolean1464 = true;
		if (itemDef.stackable)
			sprite2.maxWidth = 33;
		else
			sprite2.maxWidth = 32;
		sprite2.maxHeight = j;
		return sprite2;
	}

	public Model method201(int i) {
		if (stackIDs != null && i > 1) {
			int j = -1;
			for (int k = 0; k < 10; k++)
				if (i >= stackAmounts[k] && stackAmounts[k] != 0)
					j = stackIDs[k];
			if (j != -1)
				return forID(j).method201(1);
		}
		Model model = (Model) mruNodes2.insertFromCache(id);
		if (model != null)
			return model;
		model = Model.method462(modelid);
		if (model == null)
			return null;
		if (anInt167 != 128 || anInt192 != 128 || anInt191 != 128)
			model.method478(anInt167, anInt191, anInt192);
		if (editedModelColor != null) {
			for (int l = 0; l < editedModelColor.length; l++)
				model.method476(editedModelColor[l], newModelColor[l]);
		}
		model.method479(64 + anInt196, 768 + anInt184, -50, -10, -50, true);
		model.aBoolean1659 = true;
		mruNodes2.removeFromCache(model, id);
		return model;
	}

	public Model method202(int i) {
		if (stackIDs != null && i > 1) {
			int j = -1;
			for (int k = 0; k < 10; k++)
				if (i >= stackAmounts[k] && stackAmounts[k] != 0)
					j = stackIDs[k];
			if (j != -1)
				return forID(j).method202(1);
		}
		Model model = Model.method462(modelid);
		if (model == null)
			return null;
		if (editedModelColor != null) {
			for (int l = 0; l < editedModelColor.length; l++)
				model.method476(editedModelColor[l], newModelColor[l]);
		}
		return model;
	}

	public ItemDef() {
		id = -1;
	}

	public byte aByte154;
	public int value;
	public int[] editedModelColor;
	public int id;
	static MRUNodes mruNodes1 = new MRUNodes(100);
	public static MRUNodes mruNodes2 = new MRUNodes(50);
	public int[] newModelColor;
	public boolean membersObject;
	public int anInt162;
	public int certTemplateID;
	public int anInt164;
	public int anInt165;
	public int anInt166;
	public int anInt167;
	public String groundActions[];
	public int modelOffset1;
	public String name;
	public static ItemDef[] cache;
	public static String femaleItems[] ={"whip", "Statius warhammer", "maul", "warhammer", "-om", "spear", "hammer", "sword", "defender", "rapier", "staff", "banner", "mace", "dagger", "scimitar", "spear", "flail", "maul", "axe", "bow", "knife", "tenderiser", "defender", "cannon", "chinchompa"};
	public static String femaleItemsTwo[] ={"morrigan's javelin"};
	public static String femaleItemsThree[] ={"korasi","katana"};
	public int anInt173;
	public int modelid;
	public int anInt175;
	public boolean stackable;
	public String description;
	public int certID;
	public static int cacheIndex;
	public int modelZoom;
	public static boolean isMembers = true;
	public static Stream stream;
	public int anInt184;
	public int anInt185;
	public int anInt188;
	public String itemActions[];
	public int modelRotationY;
	public int anInt191;
	public int anInt192;
	public int[] stackIDs;
	public int modelOffset2;
	public static int[] streamIndices;
	public int anInt196;
	public int anInt197;
	public int modelRotationX;
	public int anInt200;
	public int[] stackAmounts;
	public int team;
	public static int totalItems;
	public int anInt204;
	public byte aByte205;
	public int lendID;
	public int lentItemID;
}
