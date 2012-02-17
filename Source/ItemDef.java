import java.io.*;
import sign.signlink;

public final class ItemDef {
	
	public static void dumpData() {
		/*try {
			FileWriter fw = new FileWriter("models.txt");
			for (int j = 0; j < array.length; j++) {
				ItemDef item = ItemDef.forID(array[j]);
				fw.write("" + item.modelID + ",\r\n" + item.maleEquip1 + ",\r\n" + item.maleEquip2 + ",\r\n" + item.femaleEquip1 + ",\r\n" + item.femaleEquip2 + ",\r\n");
			}
			fw.close();
		} catch (IOException ioe) {ioe.printStackTrace();}*/
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
		int k = maleEquip1;
		int l = maleEquip2;
		int i1 = anInt185;
		if (j == 1) {
			k = femaleEquip1;
			l = femaleEquip2;
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
		int j = maleEquip1;
		int k = maleEquip2;
		int l = anInt185;
		if (i == 1) {
			j = femaleEquip1;
			k = femaleEquip2;
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

	public void setDefaults() {
		modelID = 0;
		name = null;
		description = null;
		editedModelColor = null;
		newModelColor = null;
		modelZoom = 2000;
		modelRotation1 = 0;
		modelRotation2 = 0;
		anInt204 = 0;
		modelOffset1 = 0;
		modelOffset2 = 0;
		stackable = false;
		value = 1;
		membersObject = false;
		groundActions = null;
		actions = null;
		maleEquip1 = -1;
		maleEquip2 = -1;
		aByte205 = 0;
		femaleEquip1 = -1;
		femaleEquip2 = -1;
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

	public static void unpackConfig(StreamLoader streamLoader) {
		/*stream = new Stream(FileOperations.ReadFile("./Cache/obj.dat"));
		Stream stream = new Stream(FileOperations.ReadFile("./Cache/obj.idx")); */
		stream = new Stream(streamLoader.getDataForName("obj.dat"));
		Stream stream = new Stream(streamLoader.getDataForName("obj.idx"));
		totalItems = stream.readUnsignedWord();
		streamIndices = new int[totalItems+1000];
		int i = 2;
		for (int j = 0; j < totalItems; j++) {
			streamIndices[j] = i;
			i += stream.readUnsignedWord();
		}
		cache = new ItemDef[10];
		for (int k = 0; k < 10; k++)
			cache[k] = new ItemDef();
	}

	public static ItemDef forID(int i) {
		for (int j = 0; j < 10; j++)
			if (cache[j].ID == i)
				return cache[j];
		cacheIndex = (cacheIndex + 1) % 10;
		ItemDef itemDef = cache[cacheIndex];
		stream.currentOffset = streamIndices[i];
		itemDef.ID = i;
		itemDef.setDefaults();
		itemDef.readValues(stream);
		if (itemDef.certTemplateID != -1)
			itemDef.toNote();
		if (itemDef.lentItemID != -1)
			itemDef.toLend();
		if (!isMembers && itemDef.membersObject) {
			itemDef.name = "Members Object";
			itemDef.description = "Login to a members' server to use this object.";
			itemDef.groundActions = null;
			itemDef.actions = null;
			itemDef.team = 0;
		}
		switch (i) {
                                   case 995:
                        itemDef.name = "Coins";
                        itemDef.actions = new String[5];
                        itemDef.actions[4] = "Drop";
                        itemDef.actions[3] = "Add-to-pouch";
                break;
                    			case 14028:
		itemDef.name = "Completionist Cape";
		itemDef.description = "We would pat you on the back but this cape would get in the way.";
		itemDef.modelID = 65270;
		itemDef.editedModelColor = new int [3];
		itemDef.newModelColor = new int [3];
		itemDef.editedModelColor[0] = 65214;
		itemDef.newModelColor[0] = 122;
		itemDef.editedModelColor[1] = 65200;
		itemDef.newModelColor[1] = 122;
		itemDef.editedModelColor[2] = 65186;
		itemDef.newModelColor[2] = 122;
		itemDef.maleEquip1 = 65295;
		itemDef.femaleEquip1 = 65295;
		itemDef.modelID = 65258;
		itemDef.modelRotation2 = 252;
		itemDef.modelRotation1 = 1020;
		itemDef.modelZoom = 1316;
		itemDef.modelOffset2 = -1;
		itemDef.modelOffset1 = 14;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.actions[2] = "Customise";
		itemDef.actions[3] = "Features";
		itemDef.actions[4] = "Destroy";
	break;
				case 14029:
		itemDef.name = "Completionist Cape";
		itemDef.description = "We would pat you on the back but this cape would get in the way.";
		itemDef.modelID = 65270;
		itemDef.editedModelColor = new int [3];
		itemDef.newModelColor = new int [3];
		itemDef.editedModelColor[0] = 65214;
		itemDef.newModelColor[0] = 8128;
		itemDef.editedModelColor[1] = 65200;
		itemDef.newModelColor[1] = 8128;
		itemDef.editedModelColor[2] = 65186;
		itemDef.newModelColor[2] = 8128;
		itemDef.maleEquip1 = 65295;
		itemDef.femaleEquip1 = 65295;
		itemDef.modelID = 65258;
		itemDef.modelRotation2 = 252;
		itemDef.modelRotation1 = 1020;
		itemDef.modelZoom = 1316;
		itemDef.modelOffset2 = -1;
		itemDef.modelOffset1 = 14;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.actions[2] = "Customise";
		itemDef.actions[3] = "Features";
		itemDef.actions[4] = "Destroy";
	break;
			
			case 14031:
		itemDef.name = "Completionist Cape";
		itemDef.description = "We would pat you on the back but this cape would get in the way.";
		itemDef.maleEquip1 = 65295;
		itemDef.femaleEquip1 = 65295;
		itemDef.modelID = 65258;
		itemDef.modelRotation2 = 252;
		itemDef.modelRotation1 = 1020;
		itemDef.modelZoom = 1316;
		itemDef.modelOffset2 = -1;
		itemDef.modelOffset1 = 14;
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
		itemDef.newModelColor[0] = 11200;
		itemDef.newModelColor[1] = 4550;
		itemDef.newModelColor[2] = 6073;
		itemDef.newModelColor[3] = 11200;
		break;
		
					case 14034:
		itemDef.name = "Completionist Cape";
		itemDef.description = "We would pat you on the back but this cape would get in the way.";
		itemDef.maleEquip1 = 65295;
		itemDef.femaleEquip1 = 65295;
		itemDef.modelID = 65258;
		itemDef.modelRotation2 = 252;
		itemDef.modelRotation1 = 1020;
		itemDef.modelZoom = 1316;
		itemDef.modelOffset2 = -1;
		itemDef.modelOffset1 = 14;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.actions[2] = "Customise";
		itemDef.actions[3] = "Features";
		itemDef.actions[4] = "Destroy";
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
		itemDef.maleEquip1 = 65295;
		itemDef.femaleEquip1 = 65295;
		itemDef.modelID = 65258;
		itemDef.modelRotation2 = 252;
		itemDef.modelRotation1 = 1020;
		itemDef.modelZoom = 1316;
		itemDef.modelOffset2 = -1;
		itemDef.modelOffset1 = 14;
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
		itemDef.newModelColor[0] = 2;
		itemDef.newModelColor[1] = 2;
		itemDef.newModelColor[2] = 61;
		itemDef.newModelColor[3] = 61;
		break;
		case 14033://new
		itemDef.name = "Completionist hood";
		itemDef.description = "We would pat you on the back but this cape would get in the way.";
		itemDef.maleEquip1 = 65292;
		itemDef.femaleEquip1 = 65310;
		itemDef.modelID = 65273;
		itemDef.modelRotation2 = 11;
		itemDef.modelRotation1 = 81;
		itemDef.modelZoom = 760;
		itemDef.modelOffset2 = 1;
		itemDef.modelOffset1 = -3;
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
		itemDef.newModelColor[0] = 61;
		itemDef.newModelColor[1] = 61;
		itemDef.newModelColor[2] = 61;
		itemDef.newModelColor[3] = 61;
		break;
		case 14035://new
		itemDef.name = "Completionist hood";
		itemDef.description = "We would pat you on the back but this cape would get in the way.";
		itemDef.maleEquip1 = 65292;
		itemDef.femaleEquip1 = 65310;
		itemDef.modelID = 65273;
		itemDef.modelRotation2 = 11;
		itemDef.modelRotation1 = 81;
		itemDef.modelZoom = 760;
		itemDef.modelOffset2 = 1;
		itemDef.modelOffset1 = -3;
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
		itemDef.newModelColor[0] = 11200;
		itemDef.newModelColor[1] = 11200;
		itemDef.newModelColor[2] = 6073;
		itemDef.newModelColor[3] = 11200;
		break;
		case 14036://new
		itemDef.name = "Abyssal vine whip";
		itemDef.modelID = 10247;
		itemDef.modelZoom = 848;
		itemDef.modelRotation2 = 324;
		itemDef.modelRotation1 = 1808;
		itemDef.modelOffset1 = 5;
		itemDef.modelOffset2 = 38;
		itemDef.maleEquip1 = 10253;
		itemDef.femaleEquip1 = 10253;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.description = "An Abyssal Whip with a vine attached to it";
		break;

		case 14039://new
		itemDef.name = "Completionist hood";
		itemDef.description = "We would pat you on the back but this cape would get in the way.";
		itemDef.maleEquip1 = 65292;
		itemDef.femaleEquip1 = 65310;
		itemDef.modelID = 65273;
		itemDef.modelRotation2 = 11;
		itemDef.modelRotation1 = 81;
		itemDef.modelZoom = 760;
		itemDef.modelOffset2 = 1;
		itemDef.modelOffset1 = -3;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.actions[2] = "Customise";
		itemDef.actions[3] = "Features";
		itemDef.actions[4] = "Destroy";
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
		case 14042://new
		itemDef.name = "Max hood";
		itemDef.description = "It's a Max hood";
		itemDef.maleEquip1 = 65291;
		itemDef.femaleEquip1 = 65291;
		itemDef.modelID = 65268;
		itemDef.modelRotation2 = 11;
		itemDef.modelRotation1 = 81;
		itemDef.modelZoom = 760;
		itemDef.modelOffset2 = 1;
		itemDef.modelOffset1 = -3;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.actions[4] = "Destroy";
		break;
		case 14043://new
		itemDef.name = "Max cape";
		itemDef.description = "It's a Maxcape";
		itemDef.maleEquip1 = 65300;
		itemDef.femaleEquip1 = 65300;
		itemDef.modelID = 65262;
		itemDef.modelRotation2 = 279;
		itemDef.modelRotation1 = 948;
		itemDef.modelZoom = 1385;
		itemDef.modelOffset2 = -5;
		itemDef.modelOffset1 = 24;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.actions[4] = "Destroy";
		break;
		case 14044://new
		itemDef.name = "Classic hood";
		itemDef.description = "It's a Classic hood";
		itemDef.maleEquip1 = 65290;
		itemDef.femaleEquip1 = 65290;
		itemDef.modelID = 19;
		itemDef.modelRotation2 = 11;
		itemDef.modelRotation1 = 81;
		itemDef.modelZoom = 760;
		itemDef.modelOffset2 = 1;
		itemDef.modelOffset1 = -3;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.actions[4] = "Destroy";
		break;
		case 14045://new
		itemDef.name = "Classic cape";
		itemDef.description = "It's a Classic cape";
		itemDef.maleEquip1 = 65302;
		itemDef.femaleEquip1 = 65302;
		itemDef.modelID = 65257;
		itemDef.modelRotation2 = 279;
		itemDef.modelRotation1 = 948;
		itemDef.modelZoom = 1513;
		itemDef.modelOffset2 = -3;
		itemDef.modelOffset1 = 24;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.actions[4] = "Destroy";
		itemDef.editedModelColor = new int[1];
		itemDef.newModelColor = new int[1];
		itemDef.editedModelColor[0] = 0;
		itemDef.newModelColor[0] = 2;
		break;
		case 14046://new
		itemDef.name = "Veteran hood";
		itemDef.description = "It's a Veteran hood";
		itemDef.maleEquip1 = 65289;
		itemDef.femaleEquip1 = 65289;
		itemDef.modelID = 65271;
		itemDef.modelRotation2 = 11;
		itemDef.modelRotation1 = 81;
		itemDef.modelZoom = 760;
		itemDef.modelOffset2 = 1;
		itemDef.modelOffset1 = -3;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.actions[4] = "Destroy";
		itemDef.editedModelColor = new int[1];
		itemDef.newModelColor = new int[1];
		break;
		case 14047://new
		itemDef.name = "Veteran cape";
		itemDef.description = "It's a Veteran cape";
		itemDef.maleEquip1 = 65305;
		itemDef.femaleEquip1 = 65305;
		itemDef.modelID = 65261;
		itemDef.modelRotation1 = 279;
		itemDef.modelRotation2 = 948;
		itemDef.modelZoom = 1513;
		itemDef.modelOffset2 = -3;
		itemDef.modelOffset1 = 24;
		itemDef.actions = new String[5];
		itemDef.actions[1] = "Wear";
		itemDef.actions[4] = "Destroy";
		itemDef.editedModelColor = new int[1];
		itemDef.newModelColor = new int[1];
		break;
		case 20115:
			itemDef.modelID = 62694;
			itemDef.name = "Ancient ceremonial hood";
			itemDef.modelZoom = 980;
			itemDef.modelRotation1 = 208;
			itemDef.modelRotation2 = 220;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -18;
			itemDef.maleEquip1 = 62737;
			itemDef.femaleEquip1 = 62753;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[4] = "Drop";
			itemDef.anInt175 = 62730;
			itemDef.anInt197 = 62730;
		break;

		case 20116:
			itemDef.modelID = 62705;
			itemDef.name = "Ancient ceremonial top";
			itemDef.modelZoom = 1316;
			itemDef.modelRotation1 = 477;
			itemDef.modelRotation2 = 9;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 13;
			itemDef.maleEquip1 = 62745;
			itemDef.femaleEquip1 = 62763;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[4] = "Drop";
			itemDef.anInt204 = 54;
		break;

		case 20117:
			itemDef.modelID = 62707;
			itemDef.name = "Ancient ceremonial legs";
			itemDef.modelZoom = 1828;
			itemDef.modelRotation1 = 539;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = 0;
			itemDef.maleEquip1 = 62740;
			itemDef.femaleEquip1 = 62759;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[4] = "Drop";
			itemDef.anInt204 = 40;
			itemDef.anInt196 = 30;
			itemDef.anInt184 = 100;
		break;

		case 20118:
			itemDef.modelID = 62697;
			itemDef.name = "Ancient ceremonial gloves";
			itemDef.modelZoom = 548;
			itemDef.modelRotation1 = 618;
			itemDef.modelRotation2 = 1143;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -5;
			itemDef.maleEquip1 = 62735;
			itemDef.femaleEquip1 = 62752;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[4] = "Drop";
		break;

		case 20119:
			itemDef.modelID = 62696;
			itemDef.name = "Ancient ceremonial boots";
			itemDef.modelZoom = 676;
			itemDef.modelRotation1 = 63;
			itemDef.modelRotation2 = 106;
			itemDef.modelOffset1 = 5;
			itemDef.modelOffset2 = -1;
			itemDef.maleEquip1 = 62734;
			itemDef.femaleEquip1 = 62751;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[4] = "Drop";
		break;

		case 20120:
			itemDef.modelID = 57037;
			itemDef.name = "Frozen key";
			itemDef.modelZoom = 1184;
			itemDef.modelRotation1 = 384;
			itemDef.modelRotation2 = 162;
			itemDef.modelOffset1 = -8;
			itemDef.modelOffset2 = -14;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[0] = "Check-uses";
			itemDef.actions[4] = "Destroy";
		break;

		case 20121:
			itemDef.modelID = 52559;
			itemDef.name = "Frozen key piece (armadyl)";
			itemDef.description = "Frozen key piece (armadyl)";
			itemDef.modelZoom = 925;
			itemDef.modelRotation1 = 553;
			itemDef.modelRotation2 = 131;
			itemDef.modelOffset1 = 12;
			itemDef.modelOffset2 = -8;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[0] = "Assemble";
			itemDef.actions[4] = "Drop";
			itemDef.anInt167 = 260;
			itemDef.anInt192 = 260;
			itemDef.anInt191 = 260;
		break;

		case 20122:
			itemDef.modelID = 52562;
			itemDef.name = "Frozen key piece (bandos)";
			itemDef.description = "Frozen key piece (bandos)";
			itemDef.modelZoom = 720;
			itemDef.modelRotation1 = 600;
			itemDef.modelRotation2 = 223;
			itemDef.modelOffset1 = -7;
			itemDef.modelOffset2 = 2;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[0] = "Assemble";
			itemDef.actions[4] = "Drop";
			itemDef.anInt167 = 260;
			itemDef.anInt192 = 260;
			itemDef.anInt191 = 260;
		break;

		case 20123:
			itemDef.modelID = 52564;
			itemDef.name = "Frozen key piece (zamorak)";
			itemDef.description = "Frozen key piece (zamorak)";
			itemDef.modelZoom = 457;
			itemDef.modelRotation1 = 387;
			itemDef.modelRotation2 = 95;
			itemDef.modelOffset1 = 26;
			itemDef.modelOffset2 = -34;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[0] = "Assemble";
			itemDef.actions[4] = "Drop";
			itemDef.anInt167 = 260;
			itemDef.anInt192 = 260;
			itemDef.anInt191 = 260;
		break;

		case 20124:
			itemDef.modelID = 52561;
			itemDef.name = "Frozen key piece (saradomin)";
			itemDef.description = "Frozen key piece (saradomin)";
			itemDef.modelZoom = 541;
			itemDef.modelRotation1 = 444;
			itemDef.modelRotation2 = 32;
			itemDef.modelOffset1 = 16;
			itemDef.modelOffset2 = -47;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[0] = "Assemble";
			itemDef.actions[4] = "Drop";
			itemDef.anInt167 = 260;
			itemDef.anInt192 = 260;
			itemDef.anInt191 = 260;
		break;

		case 20135:
			itemDef.modelID = 62714;
			itemDef.name = "Torva full helm";
			itemDef.description = "Torva full helm";
			itemDef.modelZoom = 672;
			itemDef.modelRotation1 = 85;
			itemDef.modelRotation2 = 1867;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -3;
			itemDef.maleEquip1 = 62738;
			itemDef.femaleEquip1 = 62754;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
			itemDef.anInt175 = 62729;
			itemDef.anInt197 = 62729;
		break;

		case 20139:
			itemDef.modelID = 62699;
			itemDef.name = "Torva platebody";
			itemDef.description = "Torva platebody";
			itemDef.modelZoom = 1506;
			itemDef.modelRotation1 = 473;
			itemDef.modelRotation2 = 2042;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.maleEquip1 = 62746;
			itemDef.femaleEquip1 = 62762;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
		break;

		case 20143:
			itemDef.modelID = 62701;
			itemDef.name = "Torva platelegs";
			itemDef.description = "Torva platelegs";
			itemDef.modelZoom = 1740;
			itemDef.modelRotation1 = 474;
			itemDef.modelRotation2 = 2045;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -5;
			itemDef.maleEquip1 = 62743;
			itemDef.femaleEquip1 = 62760;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
		break;

		case 20147:
			itemDef.modelID = 62693;
			itemDef.name = "Pernix cowl";
			itemDef.description = "Pernix cowl";
			itemDef.modelZoom = 800;
			itemDef.modelRotation1 = 532;
			itemDef.modelRotation2 = 14;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = 1;
			itemDef.maleEquip1 = 62739;
			itemDef.femaleEquip1 = 62756;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
			itemDef.anInt175 = 62731;
			itemDef.anInt197 = 62727;
		break;

		case 20151:
			itemDef.modelID = 62709;
			itemDef.name = "Pernix body";
			itemDef.description = "Pernix body";
			itemDef.modelZoom = 1378;
			itemDef.modelRotation1 = 485;
			itemDef.modelRotation2 = 2042;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = 7;
			itemDef.maleEquip1 = 62744;
			itemDef.femaleEquip1 = 62765;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
		break;

		case 20155:
			itemDef.modelID = 62695;
			itemDef.name = "Pernix chaps";
			itemDef.description = "Pernix chaps";
			itemDef.modelZoom = 1740;
			itemDef.modelRotation1 = 504;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset1 = 4;
			itemDef.modelOffset2 = 3;
			itemDef.maleEquip1 = 62741;
			itemDef.femaleEquip1 = 62757;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
		break;

		case 20159:
			itemDef.modelID = 62710;
			itemDef.name = "Virtus mask";
			itemDef.description = "Virtus mask";
			itemDef.modelZoom = 928;
			itemDef.modelRotation1 = 406;
			itemDef.modelRotation2 = 2041;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = -5;
			itemDef.maleEquip1 = 62736;
			itemDef.femaleEquip1 = 62755;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
			itemDef.anInt175 = 62728;
			itemDef.anInt197 = 62728;
		break;

		case 20163:
			itemDef.modelID = 62704;
			itemDef.name = "Virtus robe top";
			itemDef.description = "Virtus robe top";
			itemDef.modelZoom = 1122;
			itemDef.modelRotation1 = 488;
			itemDef.modelRotation2 = 3;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 0;
			itemDef.maleEquip1 = 62748;
			itemDef.femaleEquip1 = 62764;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
		break;

		case 20167:
			itemDef.modelID = 62700;
			itemDef.name = "Virtus robe legs";
			itemDef.description = "Virtus robe legs";
			itemDef.modelZoom = 1740;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 2045;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = 4;
			itemDef.maleEquip1 = 62742;
			itemDef.femaleEquip1 = 62758;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
		break;

		case 20171:
			itemDef.modelID = 62692;
			itemDef.name = "Zaryte bow";
			itemDef.description = "Zaryte bow";
			itemDef.modelZoom = 1703;
			itemDef.modelRotation1 = 221;
			itemDef.modelRotation2 = 404;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -13;
			itemDef.maleEquip1 = 62750;
			itemDef.femaleEquip1 = 62750;
			itemDef.aByte154 = -11;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
		break;

		case 20175:
			itemDef.modelID = 57921;
			itemDef.name = "Trollheim tablet";
			itemDef.modelZoom = 465;
			itemDef.modelRotation1 = 373;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -1;
			itemDef.value = 1;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[0] = "Break";
			itemDef.actions[4] = "Drop";
		break;
		}
		if (itemDef.ID == i && itemDef.editedModelColor == null) {
			itemDef.editedModelColor = new int [1];
			itemDef.newModelColor = new int [1];
			itemDef.editedModelColor[0] = 0;
			itemDef.newModelColor[0] = 1;
		}
		
		
		if (itemDef.editedModelColor != null) {
			for (int i2 = 0; i2 < itemDef.editedModelColor.length; i2++) {
				if (itemDef.newModelColor[i2] == 0) {
					itemDef.newModelColor[i2] = 1;
				}
			}
		}
		return itemDef;
	}
	
	private void readValues(Stream stream) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0)
				return;
			if (i == 1) {
				modelID = stream.readUnsignedWord();
			} else if (i == 2)
				name = stream.readString();
			else if (i == 3)
				description = stream.readString();
			else if (i == 4)
				modelZoom = stream.readUnsignedWord();
			else if (i == 5)
				modelRotation1 = stream.readUnsignedWord();
			else if (i == 6)
				modelRotation2 = stream.readUnsignedWord();
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
				maleEquip1 = stream.readUnsignedWord();
				aByte205 = stream.readSignedByte();
			} else if (i == 24)
				maleEquip2 = stream.readUnsignedWord();
			else if (i == 25) {
				femaleEquip1 = stream.readUnsignedWord();
				aByte154 = stream.readSignedByte();
			} else if (i == 26)
				femaleEquip2 = stream.readUnsignedWord();
			else if (i >= 30 && i < 35) {
				if (groundActions == null)
					groundActions = new String[5];
				groundActions[i - 30] = stream.readString();
				if (groundActions[i - 30].equalsIgnoreCase("hidden"))
					groundActions[i - 30] = null;
			} else if (i >= 35 && i < 40) {
				if (actions == null)
					actions = new String[5];
				actions[i - 35] = stream.readString();
				if (actions[i - 35].equalsIgnoreCase("null"))
					actions[i - 35] = null;
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
	
	public void toNote() {
		ItemDef itemDef = forID(certTemplateID);
		modelID = itemDef.modelID;
		modelZoom = itemDef.modelZoom;
		modelRotation1 = itemDef.modelRotation1;
		modelRotation2 = itemDef.modelRotation2;
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
	
	private void toLend() {
		ItemDef itemDef = forID(lentItemID);
		actions = new String[5];
		modelID = itemDef.modelID;
		modelOffset1 = itemDef.modelOffset1;
		modelRotation2 = itemDef.modelRotation2;
		modelOffset2 = itemDef.modelOffset2;
		modelZoom = itemDef.modelZoom;
		modelRotation1 = itemDef.modelRotation1;
		anInt204 = itemDef.anInt204;
		value = 0;
		ItemDef itemDef_1 = forID(lendID);
		anInt166 = itemDef_1.anInt166;
		editedModelColor = itemDef_1.editedModelColor;
		anInt185 = itemDef_1.anInt185;
		maleEquip2 = itemDef_1.maleEquip2;
		anInt173 = itemDef_1.anInt173;
		anInt175 = itemDef_1.anInt175;
		groundActions = itemDef_1.groundActions;
		maleEquip1 = itemDef_1.maleEquip1;
		name = itemDef_1.name;
		femaleEquip1 = itemDef_1.femaleEquip1;
		membersObject = itemDef_1.membersObject;
		anInt197 = itemDef_1.anInt197;
		femaleEquip2 = itemDef_1.femaleEquip2;
		anInt162 = itemDef_1.anInt162;
		newModelColor = itemDef_1.newModelColor;
		team = itemDef_1.team;
		if (itemDef_1.actions != null) {
			for (int i_33_ = 0; i_33_ < 4; i_33_++)
				actions[i_33_] = itemDef_1.actions[i_33_];
		}
		actions[4] = "Discard";
	}

	public static Sprite getSprite(int i, int j, int k) {
		if (k == 0) {
			Sprite sprite = (Sprite) mruNodes1.insertFromCache(i);
			if (sprite != null && sprite.anInt1445 != j && sprite.anInt1445 != -1) {
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
		int l3 = Texture.anIntArray1470[itemDef.modelRotation1] * k3 >> 16;
		int i4 = Texture.anIntArray1471[itemDef.modelRotation1] * k3 >> 16;
		model.method482(itemDef.modelRotation2, itemDef.anInt204, itemDef.modelRotation1, itemDef.modelOffset1, l3 + model.modelHeight / 2 + itemDef.modelOffset2, i4 + itemDef.modelOffset2);
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
			int l5 = sprite.anInt1444;
			int j6 = sprite.anInt1445;
			sprite.anInt1444 = 32;
			sprite.anInt1445 = 32;
			sprite.drawSprite(0, 0);
			sprite.anInt1444 = l5;
			sprite.anInt1445 = j6;
		}
		if (itemDef.lentItemID != -1) {
			int l5 = sprite.anInt1444;
			int j6 = sprite.anInt1445;
			sprite.anInt1444 = 32;
			sprite.anInt1445 = 32;
			sprite.drawSprite(0, 0);
			sprite.anInt1444 = l5;
			sprite.anInt1445 = j6;
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
			sprite2.anInt1444 = 33;
		else
			sprite2.anInt1444 = 32;
		sprite2.anInt1445 = j;
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
		Model model = (Model) mruNodes2.insertFromCache(ID);
		if (model != null)
			return model;
		model = Model.method462(modelID);
		if (model == null)
			return null;
		if (anInt167 != 128 || anInt192 != 128 || anInt191 != 128)
			model.method478(anInt167, anInt191, anInt192);
		if (editedModelColor != null) {
			for (int l = 0; l < editedModelColor.length; l++)
				model.method476(editedModelColor[l], newModelColor[l]);
		}
				//model.method479(64 + anInt196, 768 + anInt184, -50, -10, -50, true); //Normal Inventory Models
		model.method479(64 + anInt196, 768 + anInt184, -50, -1000, -50, true); //HD Invertory Models
		model.aBoolean1659 = true;
		mruNodes2.removeFromCache(model, ID);
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
		Model model = Model.method462(modelID);
		if (model == null)
			return null;
		if (editedModelColor != null) {
			for (int l = 0; l < editedModelColor.length; l++)
				model.method476(editedModelColor[l], newModelColor[l]);
		}
		return model;
	}

	public ItemDef() {
		ID = -1;
	}

	public byte aByte154;
	public int value;
	public int[] editedModelColor;
	public int ID;
	static MRUNodes mruNodes1 = new MRUNodes(100);
	public static MRUNodes mruNodes2 = new MRUNodes(50);
	public int[] newModelColor;
	public boolean membersObject;
	public int anInt162;
	public int certTemplateID;
	public int femaleEquip2;
	public int maleEquip1;
	public int anInt166;
	public int anInt167;
	public String groundActions[];
	public int modelOffset1;
	public String name;
	public static ItemDef[] cache;
	public int anInt173;
	public int modelID;
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
	public int maleEquip2;
	public String actions[];
	public int modelRotation1;
	public int anInt191;
	public int anInt192;
	public int[] stackIDs;
	public int modelOffset2;
	public static int[] streamIndices;
	public int anInt196;
	public int anInt197;
	public int modelRotation2;
	public int femaleEquip1;
	public int[] stackAmounts;
	public int team;
	public static int totalItems;
	public int anInt204;
	public byte aByte205;
	public int lendID;
	public int lentItemID;
}