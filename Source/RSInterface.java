// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class RSInterface {

	public void swapInventoryItems(int i, int j) {
		int k = inv[i];
		inv[i] = inv[j];
		inv[j] = k;
		k = invStackSizes[i];
		invStackSizes[i] = invStackSizes[j];
		invStackSizes[j] = k;
	}

	public static void unpack(StreamLoader streamLoader, TextDrawingArea textDrawingAreas[], StreamLoader streamLoader_1) {
		aMRUNodes_238 = new MRUNodes(50000);
		Stream stream = new Stream(streamLoader.getDataForName("data"));
		int i = -1;
		int j = stream.readUnsignedWord();
		interfaceCache = new RSInterface[45000];
		while(stream.currentOffset < stream.buffer.length) {
			int k = stream.readUnsignedWord();
			if(k == 65535) {
				i = stream.readUnsignedWord();
				k = stream.readUnsignedWord();
			}
			RSInterface rsInterface = interfaceCache[k] = new RSInterface();
			rsInterface.id = k;
			rsInterface.parentID = i;
			rsInterface.type = stream.readUnsignedByte();
			rsInterface.atActionType = stream.readUnsignedByte();
			rsInterface.contentType = stream.readUnsignedWord();
			rsInterface.width = stream.readUnsignedWord();
			rsInterface.height = stream.readUnsignedWord();
			rsInterface.aByte254 = (byte) stream.readUnsignedByte();
			rsInterface.mOverInterToTrigger = stream.readUnsignedByte();
			if(rsInterface.mOverInterToTrigger != 0)
				rsInterface.mOverInterToTrigger = (rsInterface.mOverInterToTrigger - 1 << 8) + stream.readUnsignedByte();
			else
				rsInterface.mOverInterToTrigger = -1;
			int i1 = stream.readUnsignedByte();
			if(i1 > 0) {
				rsInterface.anIntArray245 = new int[i1];
				rsInterface.anIntArray212 = new int[i1];
				for(int j1 = 0; j1 < i1; j1++) {
					rsInterface.anIntArray245[j1] = stream.readUnsignedByte();
					rsInterface.anIntArray212[j1] = stream.readUnsignedWord();
				}

			}
			int k1 = stream.readUnsignedByte();
			if(k1 > 0) {
				rsInterface.valueIndexArray = new int[k1][];
				for(int l1 = 0; l1 < k1; l1++) {
					int i3 = stream.readUnsignedWord();
					rsInterface.valueIndexArray[l1] = new int[i3];
					for(int l4 = 0; l4 < i3; l4++)
						rsInterface.valueIndexArray[l1][l4] = stream.readUnsignedWord();

				}

			}
			if(rsInterface.type == 0) {
				rsInterface.drawsTransparent = false;
				rsInterface.scrollMax = stream.readUnsignedWord();
				rsInterface.isMouseoverTriggered = stream.readUnsignedByte() == 1;
				int i2 = stream.readUnsignedWord();
				rsInterface.children = new int[i2];
				rsInterface.childX = new int[i2];
				rsInterface.childY = new int[i2];
				for(int j3 = 0; j3 < i2; j3++) {
					rsInterface.children[j3] = stream.readUnsignedWord();
					rsInterface.childX[j3] = stream.readSignedWord();
					rsInterface.childY[j3] = stream.readSignedWord();
				}
			}
			if(rsInterface.type == 1) {
				stream.readUnsignedWord();
				stream.readUnsignedByte();
			}
			if(rsInterface.type == 2) {
				rsInterface.inv = new int[rsInterface.width * rsInterface.height];
				rsInterface.invStackSizes = new int[rsInterface.width * rsInterface.height];
				rsInterface.aBoolean259 = stream.readUnsignedByte() == 1;
				rsInterface.isInventoryInterface = stream.readUnsignedByte() == 1;
				rsInterface.usableItemInterface = stream.readUnsignedByte() == 1;
				rsInterface.aBoolean235 = stream.readUnsignedByte() == 1;
				rsInterface.invSpritePadX = stream.readUnsignedByte();
				rsInterface.invSpritePadY = stream.readUnsignedByte();
				rsInterface.spritesX = new int[20];
				rsInterface.spritesY = new int[20];
				rsInterface.sprites = new Sprite[20];
				for(int j2 = 0; j2 < 20; j2++) {
					int k3 = stream.readUnsignedByte();
					if(k3 == 1) {
						rsInterface.spritesX[j2] = stream.readSignedWord();
						rsInterface.spritesY[j2] = stream.readSignedWord();
						String s1 = stream.readString();
						if(streamLoader_1 != null && s1.length() > 0) {
							int i5 = s1.lastIndexOf(",");
							rsInterface.sprites[j2] = method207(Integer.parseInt(s1.substring(i5 + 1)), streamLoader_1, s1.substring(0, i5));
						}
					}
				}
				rsInterface.actions = new String[5];
				for(int l3 = 0; l3 < 5; l3++) {
					rsInterface.actions[l3] = stream.readString();
					if(rsInterface.actions[l3].length() == 0)
						rsInterface.actions[l3] = null;
					if(rsInterface.parentID == 1644)
						rsInterface.actions[2] = "Operate";
				}
			}
			if(rsInterface.type == 3)
				rsInterface.aBoolean227 = stream.readUnsignedByte() == 1;
			if(rsInterface.type == 4 || rsInterface.type == 1) {
				rsInterface.centerText = stream.readUnsignedByte() == 1;
				int k2 = stream.readUnsignedByte();
				if(textDrawingAreas != null)
					rsInterface.textDrawingAreas = textDrawingAreas[k2];
				rsInterface.textShadow = stream.readUnsignedByte() == 1;
			}
			if(rsInterface.type == 4) {
				rsInterface.message = stream.readString();
				rsInterface.aString228 = stream.readString();
			}
			if(rsInterface.type == 1 || rsInterface.type == 3 || rsInterface.type == 4)
				rsInterface.textColor = stream.readDWord();
			if(rsInterface.type == 3 || rsInterface.type == 4) {
				rsInterface.anInt219 = stream.readDWord();
				rsInterface.anInt216 = stream.readDWord();
				rsInterface.anInt239 = stream.readDWord();
			}
			if(rsInterface.type == 5) {
				rsInterface.drawsTransparent = false;
				String s = stream.readString();
				if(streamLoader_1 != null && s.length() > 0) {
					int i4 = s.lastIndexOf(",");
					rsInterface.sprite1 = method207(Integer.parseInt(s.substring(i4 + 1)), streamLoader_1, s.substring(0, i4));
				}
				s = stream.readString();
				if(streamLoader_1 != null && s.length() > 0) {
					int j4 = s.lastIndexOf(",");
					rsInterface.sprite2 = method207(Integer.parseInt(s.substring(j4 + 1)), streamLoader_1, s.substring(0, j4));
				}
			}
			if(rsInterface.type == 6) {
				int l = stream.readUnsignedByte();
				if(l != 0) {
					rsInterface.anInt233 = 1;
					rsInterface.mediaID = (l - 1 << 8) + stream.readUnsignedByte();
				}
				l = stream.readUnsignedByte();
				if(l != 0) {
					rsInterface.anInt255 = 1;
					rsInterface.anInt256 = (l - 1 << 8) + stream.readUnsignedByte();
				}
				l = stream.readUnsignedByte();
				if(l != 0)
					rsInterface.anInt257 = (l - 1 << 8) + stream.readUnsignedByte();
				else
					rsInterface.anInt257 = -1;
				l = stream.readUnsignedByte();
				if(l != 0)
					rsInterface.anInt258 = (l - 1 << 8) + stream.readUnsignedByte();
				else
					rsInterface.anInt258 = -1;
				rsInterface.modelZoom = stream.readUnsignedWord();
				rsInterface.modelRotation1 = stream.readUnsignedWord();
				rsInterface.modelRotation2 = stream.readUnsignedWord();
			}
			if(rsInterface.type == 7) {
				rsInterface.inv = new int[rsInterface.width * rsInterface.height];
				rsInterface.invStackSizes = new int[rsInterface.width * rsInterface.height];
				rsInterface.centerText = stream.readUnsignedByte() == 1;
				int l2 = stream.readUnsignedByte();
				if(textDrawingAreas != null)
					rsInterface.textDrawingAreas = textDrawingAreas[l2];
				rsInterface.textShadow = stream.readUnsignedByte() == 1;
				rsInterface.textColor = stream.readDWord();
				rsInterface.invSpritePadX = stream.readSignedWord();
				rsInterface.invSpritePadY = stream.readSignedWord();
				rsInterface.isInventoryInterface = stream.readUnsignedByte() == 1;
				rsInterface.actions = new String[5];
				for(int k4 = 0; k4 < 5; k4++) {
					rsInterface.actions[k4] = stream.readString();
					if(rsInterface.actions[k4].length() == 0)
						rsInterface.actions[k4] = null;
				}

			}
			if(rsInterface.atActionType == 2 || rsInterface.type == 2) {
				rsInterface.selectedActionName = stream.readString();
				rsInterface.spellName = stream.readString();
				rsInterface.spellUsableOn = stream.readUnsignedWord();
			}

			if(rsInterface.type == 8)
				rsInterface.message = stream.readString();

			if(rsInterface.atActionType == 1 || rsInterface.atActionType == 4 || rsInterface.atActionType == 5 || rsInterface.atActionType == 6) {
				rsInterface.tooltip = stream.readString();
				if(rsInterface.tooltip.length() == 0) {
					if(rsInterface.atActionType == 1)
						rsInterface.tooltip = "Ok";
					if(rsInterface.atActionType == 4)
						rsInterface.tooltip = "Select";
					if(rsInterface.atActionType == 5)
						rsInterface.tooltip = "Select";
					if(rsInterface.atActionType == 6)
						rsInterface.tooltip = "Continue";
				}
			}
		}
		aClass44 = streamLoader;
		PVPInterface(textDrawingAreas);
		PVPInterface2(textDrawingAreas);
		PVPInterface3(textDrawingAreas);
		cursequickPrayers(textDrawingAreas);
		GodWars(textDrawingAreas);
		quickPrayers(textDrawingAreas);
		Starter(textDrawingAreas);
		StarterInfomation(textDrawingAreas);
		prayerTab(textDrawingAreas);
		Curses(textDrawingAreas);
		emoteTab();
		optionTab(textDrawingAreas);
		audioOptions(textDrawingAreas);
		vidOptions(textDrawingAreas);
		Bank();
		clanChatTab(textDrawingAreas);
		Sidebar0(textDrawingAreas);
		friendsTab(textDrawingAreas);
        ignoreTab(textDrawingAreas);
		SettingsTab(textDrawingAreas);		
		Pestpanel(textDrawingAreas);
		Pestpanel2(textDrawingAreas);
		equipmentScreen2(textDrawingAreas);
		 EquipmentTab(textDrawingAreas);
		magicTab(textDrawingAreas);
		ancientMagicTab(textDrawingAreas);
		configureLunar(textDrawingAreas);
		questTab(textDrawingAreas);
		Shop(textDrawingAreas);
		Trade(textDrawingAreas);
		constructLunar();
		aMRUNodes_238 = null;
	}
	/**
	 * new
	 **/
	 
	public static void PVPInterface(TextDrawingArea[] tda) {
		RSInterface RSinterface = addInterface(21200);
		addSprite(21201, 0, "PvP/NOTINWILD1");
		addText(21202, "", tda, 1, 0xff9040, true, true);
		int last = 2;
		RSinterface.children = new int[last];
		RSinterface.childX = new int[last];
		RSinterface.childY = new int[last];
		setBounds(21201, 400, 285, 0,RSinterface);
		setBounds(21202, 418, 318, 1,RSinterface);
	}

	public static void PVPInterface2(TextDrawingArea[] tda) {
		RSInterface RSinterface = addInterface(21300);
		addSprite(21301, 0, "PvP/INWILD1");
		addText(21302, "", tda, 1, 0xff9040, true, true);
		int last = 2;
		RSinterface.children = new int[last];
		RSinterface.childX = new int[last];
		RSinterface.childY = new int[last];
		setBounds(21301, 400, 285, 0,RSinterface);
		setBounds(21302, 418, 318, 1,RSinterface);
	}

	public static void PVPInterface3(TextDrawingArea[] tda) {
		RSInterface RSinterface = addInterface(21400);
		addSprite(21401, 0, "PvP/INCOUNT1");
		addText(21402, "", tda, 1, 0xff9040, true, true);
		addText(21403, "", tda,1,0xffffff, true, true);
		int last = 2;
		RSinterface.children = new int[last];
		RSinterface.childX = new int[last];
		RSinterface.childY = new int[last];
		setBounds(21401, 400, 285, 0,RSinterface);
		setBounds(21402, 418, 318, 1,RSinterface);
		setBounds(21403, 412, 290, 1,RSinterface);
	}
	
	public static void addClickableText(int id, String text, String tooltip, TextDrawingArea tda[], int idx, int color, boolean center, boolean shadow, int width) {
        RSInterface tab = addTabInterface(id);
        tab.parentID = id;
        tab.id = id;
        tab.type = 4;
        tab.atActionType = 1;
        tab.width = width;
        tab.height = 11;
        tab.contentType = 0;
        tab.aByte254 = 0;
        tab.mOverInterToTrigger = -1;
        tab.centerText = center;
        tab.textShadow = shadow;
        tab.textDrawingAreas = tda[idx];
        tab.message = text;
        tab.aString228 = "";
        tab.textColor = color;
        tab.anInt219 = 0;
        tab.anInt216 = 0xffffff;
        tab.anInt239 = 0;
        tab.tooltip = tooltip;
    }
	public static void questTab(TextDrawingArea[] tda) {
        RSInterface tab = addTabInterface(638);
        RSInterface list = addTabInterface(16025);
        addText(640, "Quests", tda, 2, 0xeb981f, false, true);
        addText(663, "Free", tda, 2, 0xff9900, false, true);
        addText(682, "Members", tda, 2, 0xff9900, false, true);
        addSprite(16022, 4, "Bank/SPRITE");
        addText(16023, "Quest Points: ---", tda, 0, 0xeb981f, false, true);
        addSprite(16024, 5, "Bank/SPRITE");
        tab.totalChildren(6);
        tab.child(0, 640, 5, 5);
        tab.child(1, 16024, 0, 25);
        tab.child(2, 16025, 6, 24);
        tab.child(3, 16022, 0, 22);
        tab.child(4, 16022, 0, 249);
        tab.child(5, 16023, 4, 251);
        /* List/scrollbar */
        for(int i = 16026; i <= 16125; i++) {
            addClickableText(i, ""+i, "Show", tda, 0, 0xff0000, false, true, 150);
        }
        list.totalChildren(101);
        list.child(0, 663, 4, 2);
        for(int id = 1, cid = 16026; id <= 100 && cid <= 16125; id++, cid++) {
            list.childY[1] = 18;
            list.child(id, cid, 9, list.childY[id - 1] + 13);
        }
        list.width = 168;
        list.height = 225;
        list.scrollMax = 1320;
    }
	public static void Trade(TextDrawingArea[] TDA){
		RSInterface Interface = addTabInterface(3323);
		setChildren(15, Interface);
		addSprite(3324, 6, "Bank/TRADE");
		addHover(3442, 3, 0, 3325, 1, "Bank/BANK", 17, 17, "Close Window");
		addHovered(3325, 2, "Bank/BANK", 17, 17, 3326);
		addText(3417, "Trading With:", 0xFF9933, true, true, 52,TDA, 2);
		addText(3418, "Trader's Offer", 0xFF9933, false, true, 52,TDA, 1);
		addText(3419, "Your Offer", 0xFF9933, false, true, 52,TDA, 1);
		addText(3421, "Accept", 0x00C000, true, true, 52,TDA, 1);
		addText(3423, "Decline", 0xC00000, true, true, 52,TDA, 1);
		addText(3431, "Waiting For Other Player", 0xFFFFFF, true, true, 52,TDA, 1);
		addHover(3420, 1, 0, 3327, 5, "Bank/TRADE", 65, 32, "Accept");
		addHovered(3327, 2, "Bank/TRADE", 65, 32, 3328);
		addHover(3422, 3, 0, 3329, 5, "Bank/TRADE", 65, 32, "Close Window");
		addHovered(3329, 2, "Bank/TRADE", 65, 32, 3330);
		setBounds(3324, 0, 16, 0, Interface);
		setBounds(3442, 485, 24, 1, Interface);
		setBounds(3325, 485, 24, 2, Interface);
		setBounds(3417, 258, 25, 3, Interface);
		setBounds(3418, 355, 51, 4, Interface);
		setBounds(3419, 68, 51, 5, Interface);
		setBounds(3420, 223, 120, 6, Interface);
		setBounds(3327, 223, 120, 7, Interface);
		setBounds(3422, 223, 160, 8, Interface);
		setBounds(3329, 223, 160, 9, Interface);
		setBounds(3421, 256, 127, 10, Interface);
		setBounds(3423, 256, 167, 11, Interface);
		setBounds(3431, 256, 272, 12, Interface);
		setBounds(3415, 12, 64, 13, Interface);
		setBounds(3416, 321, 64, 14, Interface);
		Interface = addTabInterface(3443);
		setChildren(15, Interface);
		addSprite(3444, 3, "Bank/TRADE");
		addButton(3546, 2, "Bank/SHOP", 63, 24, "Accept", 1);
		addButton(3548, 2, "Bank/SHOP", 63, 24, "Decline", 3);
		addText(3547, "Accept", 0x00C000, true, true, 52,TDA, 1);
		addText(3549, "Decline", 0xC00000, true, true, 52,TDA, 1);
		addText(3450, "Trading With:", 0x00FFFF, true, true, 52,TDA, 2);
		addText(3451, "Yourself", 0x00FFFF, true, true, 52,TDA, 2);
		setBounds(3444, 12, 20, 0, Interface);
		setBounds(3442, 470, 32, 1, Interface);
		setBounds(3325, 470, 32, 2, Interface);
		setBounds(3535, 130, 28, 3, Interface);
		setBounds(3536, 105, 47, 4, Interface);
		setBounds(3546, 189, 295, 5, Interface);
		setBounds(3548, 258, 295, 6, Interface);
		setBounds(3547, 220, 299, 7, Interface);
		setBounds(3549, 288, 299, 8, Interface);
		setBounds(3557, 71, 87, 9, Interface);
		setBounds(3558, 315, 87, 10, Interface);
		setBounds(3533, 64, 70, 11, Interface);
		setBounds(3534, 297, 70, 12, Interface);
		setBounds(3450, 95, 289, 13, Interface);
		setBounds(3451, 95, 304, 14, Interface);
	}

	public static void Shop(TextDrawingArea[] TDA){
		RSInterface Interface = addTabInterface(3824);
		setChildren(8, Interface);
		addSprite(3825, 0, "Bank/SHOP");
		addHover(3902, 3, 0, 3826, 1, "Bank/BANK", 17, 17, "Close Window");
		addHovered(3826, 2, "Bank/BANK", 17, 17, 3827);
		addText(19679, "Main Stock", 0xFF981F, false, true, 52,TDA, 1);//3628////19679
		addText(19680, "Store Info", 0xBF751D, false, true, 52,TDA, 1);//3629//19680
		addButton(19681, 2, "Bank/SHOP", 95, 19, "Store Information", 1);//3630//19681
		setBounds(3825, 12, 12, 0, Interface);
		setBounds(3902, 471, 22, 1, Interface);
		setBounds(3826, 471, 22, 2, Interface);
		setBounds(3900, 60, 85, 3, Interface);
		setBounds(3901, 240, 21, 4, Interface);
		setBounds(19679, 42, 54, 5, Interface);
		setBounds(19680, 150, 54, 6, Interface);
		setBounds(19681, 129, 50, 7, Interface);
		Interface = interfaceCache[3900];
		Interface.invSpritePadX = 8;
		Interface.width = 10;
		Interface.height = 4;
		Interface.invSpritePadY = 19;
		Interface = addTabInterface(19682);
		addSprite(19683, 1, "Bank/SHOP");
		addText(19684, "Main Stock", 0xBF751D, false, true, 52,TDA, 1);
		addText(19685, "Store Info", 0xFF981F, false, true, 52,TDA, 1);
		addButton(19686, 2, "Bank/SHOP", 95, 19, "Main Stock", 1);
		setChildren(7, Interface);
		setBounds(19683, 12, 12, 0, Interface);
		setBounds(3901, 240, 21, 1, Interface);
		setBounds(19684, 42, 54, 2, Interface);
		setBounds(19685, 150, 54, 3, Interface);
		setBounds(19686, 23, 50, 4, Interface);
		setBounds(3902, 471, 22, 5, Interface);
		setBounds(3826, 60, 85, 6, Interface);
	}
	/**
	 * end
	 **/
	public static void Starter(TextDrawingArea[] tda) {
	RSInterface tab = addInterface(16000);
	addSprite(16001, 1, "Starter/Background");
	addHoverButton(16002, "Starter/CB", 1, 98, 64, "Melee Starter", -1, 16003, 5);
	addHoveredButton(16003, "Starter/CB", 2, 98, 64, 16004);
	addHoverButton(16005, "Starter/MAGE", 1, 98, 64, "Mage Starter", -1, 16006, 5);
	addHoveredButton(16006, "Starter/MAGE", 2, 98, 64, 16007);
	addHoverButton(16008, "Starter/RANGE", 1, 98, 64, "Range Starter", -1, 16009, 5);
	addHoveredButton(16009, "Starter/RANGE", 2, 98, 64, 16010);
	addHoverButton(16011, "Starter/question", 1, 17, 17, "Starter Infomation", -1, 16012, 5);
	addHoveredButton(16012, "Starter/questionhover", 1, 17, 17, 16013);
	addText(17001, "Choose A Starter", tda, 1, 0xFF981F, true, true);
	tab.totalChildren(10);
	tab.child(0, 16001, 45, 110);
	tab.child(1, 16002, 70, 160);
	tab.child(2, 16003, 70, 160);
	tab.child(3, 16005, 206, 160);
	tab.child(4, 16006, 206, 160);
	tab.child(5, 16008, 340, 160);
	tab.child(6, 16009, 340, 160);
	tab.child(7, 16011, 439, 116);
	tab.child(8, 16012, 439, 116);
	tab.child(9, 17001, 265, 118);
	}
	public static void StarterInfomation(TextDrawingArea[] tda) {
	RSInterface tab = addTabInterface(16100);
	addSprite(16101, 1, "StarterI/Background");
	addHoverButton(16102, "StarterI/Melee", 1, 110, 43, "Melee Infomation", -1, 16103, 5);
	addHoveredButton(16103, "StarterI/Melee", 2, 306, 218, 16104);
	addHoverButton(16105, "StarterI/Mage", 1, 110, 43, "Magic Infomation", -1, 16106, 5);
	addHoveredButton(16106, "StarterI/Mage", 2, 306, 218, 16107);
	addHoverButton(16108, "StarterI/Range", 1, 110, 43, "Range Infomation", -1, 16109, 5);
	addHoveredButton(16109, "StarterI/Range", 2, 306, 218, 16110);
	addHoverButton(16111, "StarterI/Back", 1, 16, 16, "Back to starters", -1, 16112, 5);
	addHoveredButton(16112, "StarterI/Back", 2, 16, 16, 16113);
	addText(17002, "Starter Infomation", tda, 1, 0xFF981F, true, true);
	addText(17003, "Hover over the buttons below so see what each starter contains", tda, 1, 0xFF981F, true, true);
	tab.totalChildren(11);
	tab.child(0, 16101, 30, 10);
	tab.child(1, 16102, 45, 92);
	tab.child(2, 16103, 45, 92);
	tab.child(3, 16105, 199, 92);
	tab.child(4, 16106, 157, 91);
	tab.child(5, 16108, 350, 92);
	tab.child(6, 16109, 154, 92);
	tab.child(7, 16111, 38, 17);
	tab.child(8, 16112, 38, 17);
	tab.child(9, 17003, 255, 55);
	tab.child(10, 17002, 260, 17);
	}
	public static void magicTab(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(1151);
		RSInterface homeHover = addTabInterface(1196);
		RSInterface spellButtons = interfaceCache[12424];
		spellButtons.scrollMax = 0; spellButtons.height = 260; spellButtons.width = 190;
		int[] spellButton = {
			1196, 1199, 1206, 1215, 1224, 1231, 1240, 1249, 1258, 1267, 1274, 1283, 1573,
			1290, 1299, 1308, 1315, 1324, 1333, 1340, 1349, 1358, 1367, 1374, 1381, 1388,
			1397, 1404, 1583, 12038, 1414, 1421, 1430, 1437, 1446, 1453, 1460, 1469, 15878,
			1602, 1613, 1624, 7456, 1478, 1485, 1494, 1503, 1512, 1521, 1530, 1544, 1553,
			1563, 1593, 1635, 12426, 12436, 12446, 12456, 6004, 18471
		};
		tab.totalChildren(63);
		tab.child(0, 12424, 13, 24);
		for(int i1 = 0; i1 < spellButton.length; i1++) {
			int yPos = i1 > 34 ? 8 : 183;
			tab.child(1, 1195, 13, 24);
			tab.child(i1 + 2, spellButton[i1], 5, yPos);
			addButton(1195, 1, "Custom/Magic/Home", "Cast @gre@Home Teleport");
			RSInterface homeButton = interfaceCache[1195];
			homeButton.mOverInterToTrigger = 1196;
		}
		for(int i2 = 0; i2 < spellButton.length; i2++) {
			if(i2 < 60)
				spellButtons.childX[i2] = spellButtons.childX[i2] + 24;
			if(i2 == 6 || i2 == 12 || i2 == 19 || i2 == 35 || i2 == 41 || i2 == 44 || i2 == 49 || i2 == 51)
				spellButtons.childX[i2] = 0;
			spellButtons.childY[6] = 24; spellButtons.childY[12] = 48;
			spellButtons.childY[19] = 72; spellButtons.childY[49] = 96;
			spellButtons.childY[44] = 120; spellButtons.childY[51] = 144;
			spellButtons.childY[35] = 170; spellButtons.childY[41] = 192;
		}
		homeHover.isMouseoverTriggered = true;
		addText(1197, "Level 0: Home Teleport", tda, 1, 0xFE981F, true, true);
		RSInterface homeLevel = interfaceCache[1197]; homeLevel.width = 174; homeLevel.height = 68;
		addText(1198, "A teleport which requires no", tda, 0, 0xAF6A1A, true, true);
		addText(18998, "runes and no required level that", tda, 0, 0xAF6A1A, true, true);
		addText(18999, "teleports you to the main land.", tda, 0, 0xAF6A1A, true, true);
		homeHover.totalChildren(4);
		homeHover.child(0, 1197, 3, 4);
		homeHover.child(1, 1198, 91, 23);
		homeHover.child(2, 18998, 91, 34);
		homeHover.child(3, 18999, 91, 45);
	}
	
	public static void ancientMagicTab(TextDrawingArea[] tda) {
		RSInterface tab = addInterface(12855);
		addButton(12856, 1, "Custom/Magic/Home", "Cast @gre@Home Teleport");
		RSInterface homeButton = interfaceCache[12856]; 
		homeButton.mOverInterToTrigger = 1196;
		int[] itfChildren = {
			12856, 12939, 12987, 13035, 12901, 12861, 13045, 12963, 13011, 13053, 12919, 12881, 13061,
			12951, 12999, 13069, 12911, 12871, 13079, 12975, 13023, 13087, 12929, 12891, 13095, 1196,
			12940, 12988, 13036, 12902, 12862, 13046, 12964, 13012, 13054, 12920, 12882, 13062, 12952,
			13000, 13070, 12912, 12872, 13080, 12976, 13024, 13088, 12930, 12892, 13096
		};
		tab.totalChildren(itfChildren.length);
		for(int i1 = 0, xPos = 18, yPos = 8; i1 < itfChildren.length; i1++, xPos += 45) {
			if(xPos > 175) {
				xPos = 18; yPos += 28;
			}
			if(i1 < 25)
				tab.child(i1, itfChildren[i1], xPos, yPos);
			if(i1 > 24) {
				yPos = i1 < 41 ? 181 : 1;
				tab.child(i1, itfChildren[i1], 4, yPos);
			}
		}
	}
	
	public static void drawBlackBox(int xPos, int yPos) {
        ///Light Coloured Borders\\\
		DrawingArea.drawPixels(71, yPos - 1, xPos - 2, 0x726451, 1); // Left line
		DrawingArea.drawPixels(69, yPos, xPos + 174, 0x726451, 1); // Right line
		DrawingArea.drawPixels(1, yPos - 2, xPos - 2, 0x726451, 178); // Top Line
		DrawingArea.drawPixels(1, yPos + 68, xPos, 0x726451, 174); // Bottom Line

        ///Dark Coloured Borders\\\
		DrawingArea.drawPixels(71, yPos - 1, xPos - 1, 0x2E2B23, 1); // Left line
		DrawingArea.drawPixels(71, yPos - 1, xPos + 175, 0x2E2B23, 1); // Right line
		DrawingArea.drawPixels(1, yPos - 1, xPos, 0x2E2B23, 175); // Top line
		DrawingArea.drawPixels(1, yPos + 69, xPos, 0x2E2B23, 175); // Top line

        ///Black Box\\\
        DrawingArea.method335(0x000000, yPos, 174, 68, 220, xPos); //Yes method335 is galkons opacity method
    }
	
	public static void addTransparentSprite(int id, int spriteId, String spriteName, int opacity) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 10;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.aByte254 = (byte)opacity;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(spriteId, spriteName);
		tab.sprite2 = imageLoader(spriteId, spriteName); 
		tab.width = 512;
		tab.height = 334;
		tab.drawsTransparent = true;
	}
	
	public static void addButton(int id, int sid, String spriteName, String tooltip) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 1;
		tab.contentType = 0;
		tab.aByte254 = (byte)0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(sid, spriteName);
		tab.sprite2 = imageLoader(sid, spriteName);
		tab.width = tab.sprite1.myWidth;
		tab.height = tab.sprite2.myHeight;
		tab.tooltip = tooltip;
	}
	
	public static void SettingsTab(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(6299);
		
		addText(37050, "Client Settings", tda, 1, 0xFFFFFF, false, true);
		addText(37051, "Change GameFrame", tda, 0, 0xFFFFFF, false, true);
		addText(37052, "", tda, 0, 0xFFFFFF, false, true);
		addText(37053, "x10 hits", tda, 0, 0xFFFFFF, false, true);
		addText(37054, "", tda, 0, 0xFFFFFF, false, true);
		addText(37055, "", tda, 0, 0xFFFFFF, false, true);
		addText(37056, "", tda, 0, 0xFFFFFF, false, true);
		addText(37057, "Fog", tda, 0, 0xFFFFFF, false, true);
		addText(37058, "", tda, 0, 0xFFFFFF, false, true);
		addText(37059, "", tda, 0, 0xFFFFFF, false, true);
		addText(37060, "", tda, 0, 0x67E300, false, true);
		addText(37061, "", tda, 0, 0xF30021, false, true);
		addText(37062, "", tda, 0, 0x67E300, false, true);
		addText(37063, "", tda, 0, 0xF30021, false, true);
		addText(37064, "", tda, 0, 0xF30021, false, true);
		addText(37065, "", tda, 0, 0x67E300, false, true);
		
		addButton(37008, 0, "Switcher/fullscreen", 63, 24, "FullScreen Mode", 1);
		addButton(37009, 1, "Switcher/SmallerTextBox", 63, 24, "gamframe", 1);
		addButton(37010, 1, "Switcher/SmallerTextBox", 63, 24, "Low/High Detail", 1);
		addButton(37011, 1, "Switcher/SmallerTextBox", 63, 24, "Toggle On/Off", 1);
		addButton(37012, 1, "Switcher/SmallerTextBox", 63, 24, "Toggle On/Off", 1);
		addButton(37013, 1, "Switcher/SmallerTextBox", 63, 24, "Toggle On/Off", 1);
		
		addSprite(37014, 0, "Switcher/line");
		addSprite(37015, 0, "Switcher/line");
				
		addHoverButton(37002, "Switcher/fixed", 0, 55, 48, "Fixed Mode", -1, 37003, 1);
			addHoveredButton(37003, "Switcher/fixed", 1, 55, 48, 37004);	
		addHoverButton(37005, "Switcher/resizeable", 0, 55, 48, "Resizeable Mode", -1, 37006, 1);
			addHoveredButton(37006, "Switcher/resizeable", 1, 55, 48, 37007);	
		addHoverButton(37016, "Switcher/fullscreen", 0, 55, 48, "FullScreen Mode", -1, 37017, 1);
			addHoveredButton(37017, "Switcher/fullscreen", 1, 55, 48, 37018);
		addHoverButton(37020, "Switcher/SmallButton", 0, 35, 18, "Change Gameframe", -1, 37021, 1);
			addHoveredButton(37021, "Switcher/SmallButton", 1, 35, 18, 37022);	
		addHoverButton(37023, "Switcher/SmallButton", 0, 35, 18, "Low/High Detail", -1, 37024, 1);
			addHoveredButton(37024, "Switcher/SmallButton", 1, 35, 18, 37025);	
		addHoverButton(37026, "Switcher/SmallButton", 0, 35, 18, "Toggle On/Off", -1, 37027, 1);
			addHoveredButton(37027, "Switcher/SmallButton", 1, 35, 18, 37028);	
		addHoverButton(37029, "Switcher/SmallButton", 0, 35, 18, "Toggle On/Off", -1, 37030, 1);
			addHoveredButton(37030, "Switcher/SmallButton", 1, 35, 18, 37031);	
		addHoverButton(37033, "Switcher/SmallButton", 0, 35, 18, "Toggle On/Off", -1, 37034, 1);
			addHoveredButton(37034, "Switcher/SmallButton", 1, 35, 18, 37035);
		tab.totalChildren(39);
		
		/**
		 * Sprites
		 **/
		tab.child(0, 37014, 0, 80);
		tab.child(1, 37015, 0, 22);
		
		/**
		 * Buttons
		 **/
       	tab.child(2, 37009, 5, 110);
       	tab.child(3, 37010, 5, 140);
       	tab.child(4, 37011, 5, 170);
       	tab.child(5, 37012, 5, 200);
       	tab.child(6, 37013, 5, 230);
		 
		/**
		 * Hovering buttons
		 **/
		tab.child(7, 37002, 5, 30);
		tab.child(8, 37003, 5, 30);
		tab.child(9, 37005, 68, 30);
		tab.child(10, 37006, 68, 30);	
		tab.child(11, 37016, 130, 30);
		tab.child(12, 37017, 130, 30);
		tab.child(13, 37020, 140, 110);
		tab.child(14, 37021, 140, 110);
		tab.child(15, 37023, 140, 140);
		tab.child(16, 37024, 140, 140);
		tab.child(17, 37026, 140, 170);
		tab.child(18, 37027, 140, 170);
		tab.child(19, 37029, 140, 200);
		tab.child(20, 37030, 140, 200);
		tab.child(21, 37033, 140, 230);
		tab.child(22, 37034, 140, 230);
		
		/**
		 * Text
		 **/
		tab.child(38, 37050, 50, 3);
		tab.child(23, 37051, 8, 113);
		tab.child(24, 37052, 8, 143);
		tab.child(25, 37053, 8, 173);
		tab.child(26, 37054, 8, 143);
		tab.child(27, 37055, 8, 173);
		tab.child(28, 37056, 8, 203);
		tab.child(29, 37057, 8, 233);
		tab.child(30, 37058, 146, 113);
		tab.child(31, 37059, 146, 143);
		tab.child(32, 37060, 146, 173);
		tab.child(33, 37061, 146, 203);
		tab.child(34, 37062, 146, 233);
		tab.child(35, 37063, 146, 173);
		tab.child(36, 37064, 146, 203);
		tab.child(37, 37065, 146, 233);
		
	}
	
	public static void Bank(){
		RSInterface Interface = addTabInterface(5292);
		setChildren(19, Interface);
		addSprite(5293, 0, "Bank/BANK");
		setBounds(5293, 13, 13, 0, Interface);
		addHover(5384, 3, 0, 5380, 1, "Bank/BANK", 17, 17, "Close Window");
		addHovered(5380, 2, "Bank/BANK", 17, 17, 5379);
		setBounds(5384, 476, 16, 3, Interface);
		setBounds(5380, 476, 16, 4, Interface);	
		addHover(5294, 4, 0, 5295, 3, "Bank/BANK", 114, 25, "Set A Bank PIN");
		addHovered(5295, 4, "Bank/BANK", 114, 25, 5296);
		setBounds(5294, 110, 285, 5, Interface);
		setBounds(5295, 110, 285, 6, Interface);
		addBankHover(21000, 4, 21001, 5, 8, "Bank/BANK", 35, 25, 304, 1, "Swap Withdraw Mode", 21002, 7, 6, "Bank/BANK", 21003, "Switch to insert items \nmode", "Switch to swap items \nmode.", 12, 20);
		setBounds(21000, 25, 285, 7, Interface);
		setBounds(21001, 10, 225, 8, Interface);
		addBankHover(21004, 4, 21005, 13, 15, "Bank/BANK", 35, 25, 0, 1, "Search", 21006, 14, 16, "Bank/BANK", 21007, "Click here to search your \nbank", "Click here to search your \nbank", 12, 20);
		setBounds(21004, 65, 285, 9, Interface);
		setBounds(21005, 50, 225, 10, Interface);
		addBankHover(21008, 4, 21009, 9, 11, "Bank/BANK", 35, 25, 115, 1, "Search", 21010, 10, 12, "Bank/BANK", 21011, "Switch to note withdrawal \nmode", "Switch to item withdrawal \nmode", 12, 20);
		setBounds(21008, 240, 285, 11, Interface);
		setBounds(21009, 225, 225, 12, Interface);
		addBankHover1(21012, 5, 21013, 17, "Bank/BANK", 35, 25, "Deposit carried tems", 21014, 18, "Bank/BANK", 21015, "Empty your backpack into\nyour bank", 0, 20);
		setBounds(21012, 375, 285, 13, Interface);
		setBounds(21013, 360, 225, 14, Interface);
		addBankHover1(21016, 5, 21017, 19, "Bank/BANK", 35, 25, "Deposit worn items", 21018, 20, "Bank/BANK", 21019, "Empty the items your are\nwearing into your bank", 0, 20);
		setBounds(21016, 415, 285, 15, Interface);
		setBounds(21017, 400, 225, 16, Interface);
		addBankHover1(21020, 5, 21021, 21, "Bank/BANK", 35, 25, "Deposit beast of burden inventory.", 21022, 22, "Bank/BANK", 21023, "Empty your BoB's inventory\ninto your bank", 0, 20);
		setBounds(21020, 455, 285, 17, Interface);
		setBounds(21021, 440, 225, 18, Interface);
		setBounds(5383, 170, 15, 1, Interface);
		setBounds(5385, -4, 74, 2, Interface);
		Interface = interfaceCache[5385];
		Interface.height = 206;
		Interface.width = 480;
		Interface = interfaceCache[5382];
		Interface.width = 10;
		Interface.invSpritePadX = 12;
		Interface.height = 35;
	}
	public static void addBankHover(int interfaceID, int actionType, int hoverid, int spriteId, int spriteId2, String NAME, int Width, int Height, int configFrame, int configId, String Tooltip,int hoverId2, int hoverSpriteId,int hoverSpriteId2, String hoverSpriteName, int hoverId3, String hoverDisabledText, String hoverEnabledText, int X, int Y){
		RSInterface hover = addTabInterface(interfaceID);
		hover.id = interfaceID;
		hover.parentID = interfaceID;
		hover.type = 5;
		hover.atActionType = actionType;
		hover.contentType = 0;
		hover.aByte254 = 0;
		hover.mOverInterToTrigger = hoverid;
		hover.sprite1 = imageLoader(spriteId, NAME);
		hover.sprite2 = imageLoader(spriteId2, NAME);
		hover.width = Width;
		hover.tooltip = Tooltip;
		hover.height = Height;
		hover.anIntArray245 = new int[1];
		hover.anIntArray212 = new int[1];
		hover.anIntArray245[0] = 1;
		hover.anIntArray212[0] = configId;
		hover.valueIndexArray = new int[1][3];
		hover.valueIndexArray[0][0] = 5;
		hover.valueIndexArray[0][1] = configFrame;
		hover.valueIndexArray[0][2] = 0;
		hover = addTabInterface(hoverid);
		hover.parentID = hoverid;
		hover.id = hoverid;
		hover.type = 0;
		hover.atActionType = 0;
		hover.width =550;
		hover.height = 334;
		hover.isMouseoverTriggered = true;
		hover.mOverInterToTrigger = -1;
		addSprite(hoverId2, hoverSpriteId, hoverSpriteId2, hoverSpriteName, configId, configFrame);
		addHoverBox(hoverId3, interfaceID,hoverDisabledText, hoverEnabledText, configId, configFrame);
		setChildren(2, hover);
		setBounds(hoverId2, 15, 60, 0, hover);
		setBounds(hoverId3, X, Y, 1, hover);
	}
	public static void addBankHover1(int interfaceID, int actionType, int hoverid, int spriteId, String NAME,  int Width, int Height, String Tooltip, int hoverId2, int hoverSpriteId, String hoverSpriteName, int hoverId3, String hoverDisabledText, int X, int Y){
		RSInterface hover = addTabInterface(interfaceID);
		hover.id = interfaceID;
		hover.parentID = interfaceID;
		hover.type = 5;
		hover.atActionType = actionType;
		hover.contentType = 0;
		hover.aByte254 = 0;
		hover.mOverInterToTrigger = hoverid;
		hover.sprite1 = imageLoader(spriteId, NAME);
		hover.width = Width;
		hover.tooltip = Tooltip;
		hover.height = Height;
		hover = addTabInterface(hoverid);
		hover.parentID = hoverid;
		hover.id = hoverid;
		hover.type = 0;
		hover.atActionType = 0;
		hover.width =550;
		hover.height = 334;
		hover.isMouseoverTriggered = true;
		hover.mOverInterToTrigger = -1;
		addSprite(hoverId2, hoverSpriteId, hoverSpriteId, hoverSpriteName,0,0);
		addHoverBox(hoverId3, interfaceID,hoverDisabledText, hoverDisabledText, 0, 0);
		setChildren(2, hover);
		setBounds(hoverId2, 15, 60, 0, hover);
		setBounds(hoverId3, X, Y, 1, hover);
	}
	public static void addHoverBox(int id, int ParentID,String text, String text2, int configId, int configFrame) {
		RSInterface rsi = addTabInterface(id);
		rsi.id = id;
		rsi.parentID = ParentID;
		rsi.type = 8;
		rsi.aString228 = text;
		rsi.message = text2;
		rsi.anIntArray245 = new int[1];
		rsi.anIntArray212 = new int[1];
		rsi.anIntArray245[0] = 1;
		rsi.anIntArray212[0] = configId;
		rsi.valueIndexArray = new int[1][3];
		rsi.valueIndexArray[0][0] = 5;
		rsi.valueIndexArray[0][1] = configFrame;
		rsi.valueIndexArray[0][2] = 0;
	}
	public static void addSprite(int ID, int i, int i2, String name, int configId, int configFrame) {
		RSInterface Tab = addTabInterface(ID);
		Tab.id = ID;
		Tab.parentID = ID;
		Tab.type = 5;
		Tab.atActionType = 0;
		Tab.contentType = 0;
		Tab.width = 512;
		Tab.height = 334;
		Tab.aByte254 = (byte) 0;
		Tab.mOverInterToTrigger = -1;
		Tab.anIntArray245 = new int[1];
		Tab.anIntArray212 = new int[1];
		Tab.anIntArray245[0] = 1;
		Tab.anIntArray212[0] = configId;
		Tab.valueIndexArray = new int[1][3];
		Tab.valueIndexArray[0][0] = 5;
		Tab.valueIndexArray[0][1] = configFrame;
		Tab.valueIndexArray[0][2] = 0;
		Tab.sprite1 = imageLoader(i, name);
		Tab.sprite2 = imageLoader(i2, name);
	}
	public static void addHover(int i, int aT, int cT, int hoverid,int sId, String NAME, int W, int H, String tip){
		RSInterface hover = addTabInterface(i);
		hover.id = i;
		hover.parentID = i;
		hover.type = 5;
		hover.atActionType = aT;
		hover.contentType = cT;
		hover.mOverInterToTrigger = hoverid;
		hover.sprite1 = imageLoader(sId, NAME);
		hover.sprite2 = imageLoader(sId, NAME);
		hover.width = W;
		hover.height = H;
		hover.tooltip = tip;
	}
	public static void addHovered(int i, int j, String imageName, int w, int h, int IMAGEID) {
		RSInterface hover = addTabInterface(i);
		hover.parentID = i;
		hover.id = i;
		hover.type = 0;
		hover.atActionType = 0;
		hover.width = w;
		hover.height = h;
		hover.isMouseoverTriggered = true;
		hover.mOverInterToTrigger = -1;
		addSprite(IMAGEID, j, imageName);
		setChildren(1, hover);
		setBounds(IMAGEID, 0, 0, 0, hover);
	}
	
	public static void GodWars(TextDrawingArea[] TDA) {
		RSInterface rsinterface = addInterface(16210);
		addText(16211, "NPC killcount", TDA, 0, 0xff9040, true, true);
		addText(16212, "Armadyl kills", TDA, 0, 0xff9040, true, true);
		addText(16213, "Bandos kills", TDA, 0, 0xff9040, true, true);
		addText(16214, "     Saradomin kills", TDA, 0, 0xff9040, true, true);
		addText(16215, "  Zamorak kills", TDA, 0, 0xff9040, true, true);
		addText(16216, "0", TDA, 0, 0x66FFFF, true, true);//armadyl
		addText(16217, "0", TDA, 0, 0x66FFFF, true, true);//bandos
		addText(16218, "0", TDA, 0, 0x66FFFF, true, true);//saradomin
		addText(16219, "0", TDA, 0, 0x66FFFF, true, true);//zamorak
		rsinterface.scrollMax = 0;
		rsinterface.children = new int[9];
		rsinterface.childX = new int[9];
		rsinterface.childY = new int[9];
		rsinterface.children[0] = 16211;
			rsinterface.childX[0] = -52+375+30;		rsinterface.childY[0] = 7;
		rsinterface.children[1] = 16212;
			rsinterface.childX[1] = -52+375+30;		rsinterface.childY[1] = 30;
		rsinterface.children[2] = 16213;
			rsinterface.childX[2] = -52+375+30;		rsinterface.childY[2] = 44;
		rsinterface.children[3] = 16214;
		rsinterface.childX[3] = -52+375+30;		rsinterface.childY[3] = 58;
			rsinterface.children[4] = 16215;
			rsinterface.childX[4] = -52+375+30;		rsinterface.childY[4] = 73;
		
		rsinterface.children[5] = 16216;
			rsinterface.childX[5] = -52+460+60;		rsinterface.childY[5] = 31;
		rsinterface.children[6] = 16217;
			rsinterface.childX[6] = -52+460+60;		rsinterface.childY[6] = 45;
		rsinterface.children[7] = 16218;
			rsinterface.childX[7] = -52+460+60;		rsinterface.childY[7] = 59;
		rsinterface.children[8] = 16219;
			rsinterface.childX[8] = -52+460+60;		rsinterface.childY[8] = 74;
	}
	
	public static void cursequickPrayers(TextDrawingArea[] TDA) {
	int frame = 0;
	RSInterface tab = addTabInterface(18200);
    addSprite(17201, 3, "/Interfaces/QuickPrayer/Sprite");
    addText(17235, "Select your quick curses:", TDA, 0, 16750623, false, true);
    addTransparentSprite(17249, 0, "/Interfaces/QuickPrayer/Sprite", 50);
    int j = 17202; for (int k = 630; (j <= 17222) || (k <= 656); k++) {
      addConfigButton(j, 17200, 2, 1, "/Interfaces/QuickPrayer/Sprite", 14, 15, "Select", 0, 1, k);
		j++;
    }
		setChildren(46, tab);
		setBounds(22504, 5, 8+17, frame++, tab);
		setBounds(22506, 44, 8+20, frame++, tab);
		setBounds(22508, 79, 11+19, frame++, tab);
		setBounds(22510, 116, 10+18, frame++, tab);
		setBounds(22512, 153, 9+20, frame++, tab);
		setBounds(22514, 5, 48+18, frame++, tab);
		setBounds(22516, 44, 47+21, frame++, tab);
		setBounds(22518, 79, 49+20, frame++, tab);	
		setBounds(22520, 116, 50+19, frame++, tab);
		setBounds(22522, 154, 50+20, frame++, tab);		
		setBounds(22524, 4, 84+21, frame++, tab);		
		setBounds(22526, 44, 87+19, frame++, tab);		
		setBounds(22528, 81, 85+20, frame++, tab);	
		setBounds(22530, 117, 85+20, frame++, tab);					
		setBounds(22532, 156, 87+18, frame++, tab);			
		setBounds(22534, 5, 125+19, frame++, tab);			
		setBounds(22536, 43, 124+19, frame++, tab);		
		setBounds(22538, 83, 124+20, frame++, tab);										
		setBounds(22540, 115, 125+21, frame++, tab);
		setBounds(22542, 154, 126+22, frame++, tab);
    	setBounds(17249, 0, 25, frame++, tab);
		setBounds(17201, 0, 22, frame++, tab);
    	setBounds(17201, 0, 237, frame++, tab);
    	setBounds(17202, 2, 25, frame++, tab);
    	setBounds(17203, 41, 25, frame++, tab);
    	setBounds(17204, 76, 25, frame++, tab);
    	setBounds(17205, 113, 25, frame++, tab);
    	setBounds(17206, 150, 25, frame++, tab);
    	setBounds(17207, 2, 65, frame++, tab);
    	setBounds(17208, 41, 65, frame++, tab);
    	setBounds(17209, 76, 65, frame++, tab);
    	setBounds(17210, 113, 65, frame++, tab);
    	setBounds(17211, 150, 65, frame++, tab);
    	setBounds(17212, 2, 102, frame++, tab);
    	setBounds(17213, 41, 102, frame++, tab);
    	setBounds(17214, 76, 102, frame++, tab);
    	setBounds(17215, 113, 102, frame++, tab);
    	setBounds(17216, 150, 102, frame++, tab);
    	setBounds(17217, 2, 141, frame++, tab);
    	setBounds(17218, 41, 141, frame++, tab);
    	setBounds(17219, 76, 141, frame++, tab);
    	setBounds(17220, 113, 141, frame++, tab);
    	setBounds(17221, 150, 141, frame++, tab);
    	setBounds(17235, 5, 5, frame++, tab);
    	setBounds(17241, 0, 237, frame++, tab);
    	setBounds(17242, 0, 237, frame++, tab);
	}
	
	public static void quickPrayers(TextDrawingArea[] TDA) {
   		int i = 0;
    		RSInterface localRSInterface = addTabInterface(17200);
    		addSprite(17201, 3, "/Interfaces/QuickPrayer/Sprite");
    		addText(17240, "Select your quick prayers:", 16750623, false, true, 12, TDA, 2);
    		addTransparentSprite(17249, 0, "/Interfaces/QuickPrayer/Sprite", 50);
    		int j = 17202;
		for (int k = 630; (j <= 17231) || (k <= 659); ++k) {
     			addConfigButton(j, 17200, 2, 1, "/Interfaces/QuickPrayer/Sprite", 14, 15, "Select", 0, 1, k);
			j++;
    		}
    		addHoverButton(17241, "/Interfaces/QuickPrayer/Sprite", 4, 190, 24, "Confirm Selection", -1, 17242, 1);
    		addHoveredButton(17242, "/Interfaces/QuickPrayer/Sprite", 5, 190, 24, 17243);
    		setChildren(64, localRSInterface);
    		setBounds(25001, 5, 28, i++, localRSInterface);
    		setBounds(25003, 44, 28, i++, localRSInterface);
    		setBounds(25005, 79, 31, i++, localRSInterface);
    		setBounds(25007, 116, 30, i++, localRSInterface);
    		setBounds(25009, 153, 29, i++, localRSInterface);
    		setBounds(25011, 5, 68, i++, localRSInterface);
    		setBounds(25013, 44, 67, i++, localRSInterface);
    		setBounds(25015, 79, 69, i++, localRSInterface);
    		setBounds(25017, 116, 70, i++, localRSInterface);
    		setBounds(25019, 154, 70, i++, localRSInterface);
    		setBounds(25021, 4, 104, i++, localRSInterface);
    		setBounds(25023, 44, 107, i++, localRSInterface);
    		setBounds(25025, 81, 105, i++, localRSInterface);
    		setBounds(25027, 117, 105, i++, localRSInterface);
    		setBounds(25029, 156, 107, i++, localRSInterface);
    		setBounds(25031, 5, 145, i++, localRSInterface);
    		setBounds(25033, 43, 144, i++, localRSInterface);
    		setBounds(25035, 83, 144, i++, localRSInterface);
    		setBounds(25037, 115, 141, i++, localRSInterface);
    		setBounds(25039, 154, 144, i++, localRSInterface);
    		setBounds(25041, 5, 180, i++, localRSInterface);
    		setBounds(25043, 41, 178, i++, localRSInterface);
    		setBounds(25045, 79, 183, i++, localRSInterface);
    		setBounds(25047, 116, 178, i++, localRSInterface);
    		setBounds(25049, 161, 180, i++, localRSInterface);
    		setBounds(18015, 4, 210, i++, localRSInterface);
    		setBounds(25051, 42, 219, i++, localRSInterface);
    		setBounds(18061, 78, 212, i++, localRSInterface);
    		setBounds(18121, 116, 208, i++, localRSInterface);
    		setBounds(17249, 0, 25, i++, localRSInterface);
    		setBounds(17201, 0, 22, i++, localRSInterface);
    		setBounds(17201, 0, 237, i++, localRSInterface);
    		setBounds(17202, 2, 25, i++, localRSInterface);
    		setBounds(17203, 41, 25, i++, localRSInterface);
    		setBounds(17204, 76, 25, i++, localRSInterface);
    		setBounds(17205, 113, 25, i++, localRSInterface);
    		setBounds(17206, 150, 25, i++, localRSInterface);
    		setBounds(17207, 2, 65, i++, localRSInterface);
    		setBounds(17208, 41, 65, i++, localRSInterface);
    		setBounds(17209, 76, 65, i++, localRSInterface);
    		setBounds(17210, 113, 65, i++, localRSInterface);
    		setBounds(17211, 150, 65, i++, localRSInterface);
    		setBounds(17212, 2, 102, i++, localRSInterface);
    		setBounds(17213, 41, 102, i++, localRSInterface);
    		setBounds(17214, 76, 102, i++, localRSInterface);
    		setBounds(17215, 113, 102, i++, localRSInterface);
    		setBounds(17216, 150, 102, i++, localRSInterface);
    		setBounds(17217, 2, 141, i++, localRSInterface);
    		setBounds(17218, 41, 141, i++, localRSInterface);
    		setBounds(17219, 76, 141, i++, localRSInterface);
    		setBounds(17220, 113, 141, i++, localRSInterface);
    		setBounds(17221, 150, 141, i++, localRSInterface);
    		setBounds(17222, 2, 177, i++, localRSInterface);
    		setBounds(17223, 41, 177, i++, localRSInterface);
    		setBounds(17224, 76, 177, i++, localRSInterface);
    		setBounds(17225, 113, 177, i++, localRSInterface);
    		setBounds(17226, 150, 177, i++, localRSInterface);
    		setBounds(17227, 39, 211, i++, localRSInterface);
    		setBounds(17228, 1, 211, i++, localRSInterface);
    		setBounds(17229, 75, 211, i++, localRSInterface);
    		setBounds(17230, 113, 211, i++, localRSInterface);
    		setBounds(17240, 5, 5, i++, localRSInterface);
    		setBounds(17241, 0, 237, i++, localRSInterface);
    		setBounds(17242, 0, 237, i++, localRSInterface);
    }
	
public static void Curses(TextDrawingArea[] TDA) {
		RSInterface Interface = addTabInterface(22500);
		int index = 0;
		addText(687, "99/99", 0xFF981F, false, false, -1, TDA, 1);
		addSprite(22502, 0, "CurseTab/ICON");
		addPrayer(22503, 0, 610, 49, 7, "Protect Item", 22582);//1
		addPrayer(22505, 0, 611, 49, 4, "Sap Warrior", 22544);//2
		addPrayer(22507, 0, 612, 51, 5, "Sap Ranger", 22546);//3
		addPrayer(22509, 0, 613, 53, 3, "Sap Mage", 22548);//4
		addPrayer(22511, 0, 614, 55, 2, "Sap Spirit", 22550);//5
		addPrayer(22513, 0, 615, 58, 18, "Berserker", 22552);//6
		addPrayer(22515, 0, 616, 61, 15, "Deflect Summoning", 22554);///7
		addPrayer(22517, 0, 617, 64, 17, "Deflect Magic", 22556);///8
		addPrayer(22519, 0, 618, 67, 16, "Deflect Missiles", 22558);///9
		addPrayer(22521, 0, 619, 70, 6, "Deflect Melee", 22560);///10
		addPrayer(22523, 0, 620, 73, 9, "Leech Attack", 22562);//11
		addPrayer(22525, 0, 621, 75, 10, "Leech Ranged", 22564);//12
		addPrayer(22527, 0, 622, 77, 11, "Leech Magic", 22566);//13
		addPrayer(22529, 0, 623, 79, 12, "Leech Defence", 22568);//14
		addPrayer(22531, 0, 624, 81, 13, "Leech Strength", 22570);//15
		addPrayer(22533, 0, 625, 83, 14, "Leech Energy", 22572);//16
		addPrayer(22535, 0, 626, 85, 19, "Leech Special Attack", 22574);//17
		addPrayer(22537, 0, 627, 88, 1, "Wrath", 22576);///18
		addPrayer(22539, 0, 628, 91, 8, "Soul Split", 22578);///19
		addPrayer(22541, 0, 629, 94, 20, "Turmoil", 22580);//20
		addTooltip(22582, "Level 50\nProtect Item\nKeep 1 extra item if you die");
		addTooltip(22544, "Level 50\nSap Warrior\nDrains 10% of enemy Attack,\nStrength and Defence,\nincreasing to 20% over time");
		addTooltip(22546, "Level 52\nSap Ranger\nDrains 10% of enemy Ranged\nand Defence, increasing to 20%\nover time");
		addTooltip(22548, "Level 54\nSap Mage\nDrains 10% of enemy Magic\nand Defence, increasing to 20%\nover time");
		addTooltip(22550, "Level 56\nSap Spirit\nDrains enenmy special attack\nenergy");
		addTooltip(22552, "Level 59\nBerserker\nBoosted stats last 15% longer");
		addTooltip(22554, "Level 62\nDeflect Summoning\nReduces damage dealt from\nSummoning scrolls, prevents the\nuse of a familiar's special\nattack, and can deflect some of\ndamage back to the attacker");
		addTooltip(22556, "Level 65\nDeflect Magic\nProtects against magical attacks\nand can deflect some of the\ndamage back to the attacker");
		addTooltip(22558, "Level 68\nDeflect Missiles\nProtects against ranged attacks\nand can deflect some of the\ndamage back to the attacker");
		addTooltip(22560, "Level 71\nDeflect Melee\nProtects against melee attacks\nand can deflect some of the\ndamage back to the attacker");
		addTooltip(22562, "Level 74\nLeech Attack\nBoosts Attack by 5%, increasing\nto 10% over time, while draining\nenemy Attack by 10%, increasing\nto 25% over time");
		addTooltip(22564, "Level 76\nLeech Ranged\nBoosts Ranged by 5%, increasing\nto 10% over time, while draining\nenemy Ranged by 10%,\nincreasing to 25% over\ntime");
		addTooltip(22566, "Level 78\nLeech Magic\nBoosts Magic by 5%, increasing\nto 10% over time, while draining\nenemy Magic by 10%, increasing\nto 25% over time");
		addTooltip(22568, "Level 80\nLeech Defence\nBoosts Defence by 5%, increasing\nto 10% over time, while draining\n enemy Defence by10%,\nincreasing to 25% over\ntime");
		addTooltip(22570, "Level 82\nLeech Strength\nBoosts Strength by 5%, increasing\nto 10% over time, while draining\nenemy Strength by 10%, increasing\n to 25% over time");
		addTooltip(22572, "Level 84\nLeech Energy\nDrains enemy run energy, while\nincreasing your own");
		addTooltip(22574, "Level 86\nLeech Special Attack\nDrains enemy special attack\nenergy, while increasing your\nown");
		addTooltip(22576, "Level 89\nWrath\nInflicts damage to nearby\ntargets if you die");
		addTooltip(22578, "Level 92\nSoul Split\n1/4 of damage dealt is also removed\nfrom opponent's Prayer and\nadded to your Hitpoints");
		addTooltip(22580, "Level 95\nTurmoil\nIncreases Attack and Defence\nby 15%, plus 15% of enemy's\nlevel, and Strength by 23% plus\n10% of enemy's level");
		setChildren(62, Interface);

		setBounds(687, 85, 241, index, Interface);index++;
		setBounds(22502, 65, 241, index, Interface);index++;



		setBounds(22503, 2, 5, index, Interface);index++;
		setBounds(22504, 8, 8, index, Interface);index++;

		setBounds(22505, 40, 5, index, Interface);index++;
		setBounds(22506, 47, 12, index, Interface);index++;

		setBounds(22507, 76, 5, index, Interface);index++;
		setBounds(22508, 82, 11, index, Interface);index++;

		setBounds(22509, 113, 5, index, Interface);index++;
		setBounds(22510, 116, 8, index, Interface);index++;

		setBounds(22511, 150, 5, index, Interface);index++;
		setBounds(22512, 155, 10, index, Interface);index++;


		setBounds(22513, 2, 45, index, Interface);index++;
		setBounds(22514, 9, 48, index, Interface);index++;

		setBounds(22515, 39, 45, index, Interface);index++;
		setBounds(22516, 42, 47, index, Interface);index++;

		setBounds(22517, 76, 45, index, Interface);index++;
		setBounds(22518, 79, 48, index, Interface);index++;

		setBounds(22519, 113, 45, index, Interface);index++;
		setBounds(22520, 116, 48, index, Interface);index++;

		setBounds(22521, 151, 45, index, Interface);index++;
		setBounds(22522, 154, 48, index, Interface);index++;


		setBounds(22523, 2, 82, index, Interface);index++;
		setBounds(22524, 6, 86, index, Interface);index++;

		setBounds(22525, 40, 82, index, Interface);index++;
		setBounds(22526, 42, 86, index, Interface);index++;

		setBounds(22527, 77, 82, index, Interface);index++;
		setBounds(22528, 79, 86, index, Interface);index++;

		setBounds(22529, 114, 83, index, Interface);index++;
		setBounds(22530, 119, 87, index, Interface);index++;

		setBounds(22531, 153, 83, index, Interface);index++;
		setBounds(22532, 156, 86, index, Interface);index++;


		setBounds(22533, 2, 120, index, Interface);index++;
		setBounds(22534, 7, 125, index, Interface);index++;

		setBounds(22535, 40, 120, index, Interface);index++;
		setBounds(22536, 45, 124, index, Interface);index++;

		setBounds(22537, 78, 120, index, Interface);index++;
		setBounds(22538, 86, 124, index, Interface);index++;

		setBounds(22539, 114, 120, index, Interface);index++;
		setBounds(22540, 120, 125, index, Interface);index++;

		setBounds(22541, 151, 120, index, Interface);index++;
		setBounds(22542, 153, 127, index, Interface);index++;

























		setBounds(22582, 10, 40, index, Interface);index++;
		setBounds(22544, 20, 40, index, Interface);index++;
		setBounds(22546, 20, 40, index, Interface);index++;
		setBounds(22548, 20, 40, index, Interface);index++;
		setBounds(22550, 20, 40, index, Interface);index++;
		setBounds(22552, 10, 80, index, Interface);index++;
		setBounds(22554, 10, 80, index, Interface);index++;
		setBounds(22556, 10, 80, index, Interface);index++;
		setBounds(22558, 10, 80, index, Interface);index++;
		setBounds(22560, 10, 80, index, Interface);index++;
		setBounds(22562, 10, 120, index, Interface);index++;
		setBounds(22564, 10, 120, index, Interface);index++;
		setBounds(22566, 10, 120, index, Interface);index++;
		setBounds(22568, 5, 120, index, Interface);index++;
		setBounds(22570, 5, 120, index, Interface);index++;
		setBounds(22572, 10, 160, index, Interface);index++;
		setBounds(22574, 10, 160, index, Interface);index++;
		setBounds(22576, 10, 160, index, Interface);index++;
		setBounds(22578, 10, 160, index, Interface);index++;
		setBounds(22580, 10, 160, index, Interface);index++;

		














































































































































































































	}
	
	public static void prayerTab(TextDrawingArea[] TDA)
    {
        RSInterface rsinterface = addInterface(5608);
        int i = 0;
        int j = 0;
        byte byte0 = 10;
        byte byte1 = 50;
        byte byte2 = 10;
        byte byte3 = 86;
        byte byte4 = 10;
        byte byte5 = 122;
        byte byte6 = 10;
        char c = '\237';
        byte byte7 = 10;
        byte byte8 = 86;
        int k = 1;
        byte byte9 = 52;
        addText(687, "", 0xff981f, false, true, -1, TDA, 1);
        addSprite(25105, 0, "Interfaces/PrayerTab/PRAYERICON");
        addPrayer(25000, 0, 83, 0, j, 25052, "Activate @lre@Thick Skin");
        j++;
        addPrayer(25002, 0, 84, 3, j, 25054, "Activate @lre@Burst of Strength");
        j++;
        addPrayer(25004, 0, 85, 6, j, 25056, "Activate @lre@Clarity of Thought");
        j++;
        addPrayer(25006, 0, 601, 7, j, 25058, "Activate @lre@Sharp Eye");
        j++;
        addPrayer(25008, 0, 602, 8, j, 25060, "Activate @lre@Mystic Will");
        j++;
        addPrayer(25010, 0, 86, 9, j, 25062, "Activate @lre@Rock Skin");
        j++;
        addPrayer(25012, 0, 87, 12, j, 25064, "Activate @lre@Superhuman Strength");
        j++;
        addPrayer(25014, 0, 88, 15, j, 25066, "Activate @lre@Improved Reflexes");
        j++;
        addPrayer(25016, 0, 89, 18, j, 25068, "Activate @lre@Rapid Restore");
        j++;
        addPrayer(25018, 0, 90, 21, j, 25070, "Activate @lre@Rapid Heal");
        j++;
        addPrayer(25020, 0, 91, 24, j, 25072, "Activate @lre@Protect Item");
        j++;
        addPrayer(25022, 0, 603, 25, j, 25074, "Activate @lre@Hawk Eye");
        j++;
        addPrayer(25024, 0, 604, 26, j, 25076, "Activate @lre@Mystic Lore");
        j++;
        addPrayer(25026, 0, 92, 27, j, 25078, "Activate @lre@Steel Skin");
        j++;
        addPrayer(25028, 0, 93, 30, j, 25080, "Activate @lre@Ultimate Strength");
        j++;
        addPrayer(25030, 0, 94, 33, j, 25082, "Activate @lre@Incredible Reflexes");
        j++;
        addPrayer(25032, 0, 95, 36, j, 25084, "Activate @lre@Protect from Magic");
        j++;
        addPrayer(25034, 0, 96, 39, j, 25086, "Activate @lre@Protect from Missles");
        j++;
        addPrayer(25036, 0, 97, 42, j, 25088, "Activate @lre@Protect from Melee");
        j++;
        addPrayer(25038, 0, 605, 43, j, 25090, "Activate @lre@Eagle Eye");
        j++;
        addPrayer(25040, 0, 606, 44, j, 25092, "Activate @lre@Mystic Might");
        j++;
        addPrayer(25042, 0, 98, 45, j, 25094, "Activate @lre@Retribution");
        j++;
        addPrayer(25044, 0, 99, 48, j, 25096, "Activate @lre@Redemption");
        j++;
        addPrayer(25046, 0, 100, 51, j, 25098, "Activate @lre@Smite");
        j++;
        addPrayer(25048, 0, 607, 59, j, 25100, "Activate @lre@Chivalry");
        j++;
        addPrayer(25050, 0, 608, 69, j, 25102, "Activate @lre@Piety");
        j++;
        setChildren(80, rsinterface);
        setBounds(687, 85, 241, i, rsinterface);
        i++;
        setBounds(25105, 65, 241, i, rsinterface);
        i++;
        setBounds(25000, 2, 5, i, rsinterface);
        i++;
        setBounds(25001, 5, 8, i, rsinterface);
        i++;
        setBounds(25002, 40, 5, i, rsinterface);
        i++;
        setBounds(25003, 44, 8, i, rsinterface);
        i++;
        setBounds(25004, 76, 5, i, rsinterface);
        i++;
        setBounds(25005, 79, 11, i, rsinterface);
        i++;
        setBounds(25006, 113, 5, i, rsinterface);
        i++;
        setBounds(25007, 116, 10, i, rsinterface);
        i++;
        setBounds(25008, 150, 5, i, rsinterface);
        i++;
        setBounds(25009, 153, 9, i, rsinterface);
        i++;
        setBounds(25010, 2, 45, i, rsinterface);
        i++;
        setBounds(25011, 5, 48, i, rsinterface);
        i++;
        setBounds(25012, 39, 45, i, rsinterface);
        i++;
        setBounds(25013, 44, 47, i, rsinterface);
        i++;
        setBounds(25014, 76, 45, i, rsinterface);
        i++;
        setBounds(25015, 79, 49, i, rsinterface);
        i++;
        setBounds(25016, 113, 45, i, rsinterface);
        i++;
        setBounds(25017, 116, 50, i, rsinterface);
        i++;
        setBounds(25018, 151, 45, i, rsinterface);
        i++;
        setBounds(25019, 154, 50, i, rsinterface);
        i++;
        setBounds(25020, 2, 82, i, rsinterface);
        i++;
        setBounds(25021, 4, 84, i, rsinterface);
        i++;
        setBounds(25022, 40, 82, i, rsinterface);
        i++;
        setBounds(25023, 44, 87, i, rsinterface);
        i++;
        setBounds(25024, 77, 82, i, rsinterface);
        i++;
        setBounds(25025, 81, 85, i, rsinterface);
        i++;
        setBounds(25026, 114, 83, i, rsinterface);
        i++;
        setBounds(25027, 117, 85, i, rsinterface);
        i++;
        setBounds(25028, 153, 83, i, rsinterface);
        i++;
        setBounds(25029, 156, 87, i, rsinterface);
        i++;
        setBounds(25030, 2, 120, i, rsinterface);
        i++;
        setBounds(25031, 5, 125, i, rsinterface);
        i++;
        setBounds(25032, 40, 120, i, rsinterface);
        i++;
        setBounds(25033, 43, 124, i, rsinterface);
        i++;
        setBounds(25034, 78, 120, i, rsinterface);
        i++;
        setBounds(25035, 83, 124, i, rsinterface);
        i++;
        setBounds(25036, 114, 120, i, rsinterface);
        i++;
        setBounds(25037, 115, 121, i, rsinterface);
        i++;
        setBounds(25038, 151, 120, i, rsinterface);
        i++;
        setBounds(25039, 154, 124, i, rsinterface);
        i++;
        setBounds(25040, 2, 158, i, rsinterface);
        i++;
        setBounds(25041, 5, 160, i, rsinterface);
        i++;
        setBounds(25042, 39, 158, i, rsinterface);
        i++;
        setBounds(25043, 41, 158, i, rsinterface);
        i++;
        setBounds(25044, 76, 158, i, rsinterface);
        i++;
        setBounds(25045, 79, 163, i, rsinterface);
        i++;
        setBounds(25046, 114, 158, i, rsinterface);
        i++;
        setBounds(25047, 116, 158, i, rsinterface);
        i++;
        setBounds(25048, 153, 158, i, rsinterface);
        i++;
        setBounds(25049, 161, 160, i, rsinterface);
        i++;
        setBounds(25050, 2, 196, i, rsinterface);
        i++;
        setBounds(25051, 4, 207, i, rsinterface);
        setBoundry(++i, 25052, byte0 - 2, byte1, rsinterface);
        setBoundry(++i, 25054, byte0 - 5, byte1, rsinterface);
        setBoundry(++i, 25056, byte0, byte1, rsinterface);
        setBoundry(++i, 25058, byte0, byte1, rsinterface);
        setBoundry(++i, 25060, byte0, byte1, rsinterface);
        setBoundry(++i, 25062, byte2 - 9, byte3, rsinterface);
        setBoundry(++i, 25064, byte2 - 11, byte3, rsinterface);
        setBoundry(++i, 25066, byte2, byte3, rsinterface);
        setBoundry(++i, 25068, byte2, byte3, rsinterface);
        setBoundry(++i, 25070, byte2 + 25, byte3, rsinterface);
        setBoundry(++i, 25072, byte4, byte5, rsinterface);
        setBoundry(++i, 25074, byte4 - 2, byte5, rsinterface);
        setBoundry(++i, 25076, byte4, byte5, rsinterface);
        setBoundry(++i, 25078, byte4 - 7, byte5, rsinterface);
        setBoundry(++i, 25080, byte4 - 10, byte5, rsinterface);
        setBoundry(++i, 25082, byte6, c, rsinterface);
        setBoundry(++i, 25084, byte6 - 8, c, rsinterface);
        setBoundry(++i, 25086, byte6 - 7, c, rsinterface);
        setBoundry(++i, 25088, byte6 - 2, c, rsinterface);
        setBoundry(++i, 25090, byte6 - 2, c, rsinterface);
        setBoundry(++i, 25092, byte7, byte8, rsinterface);
        setBoundry(++i, 25094, byte7, byte8 - 20, rsinterface);
        setBoundry(++i, 25096, byte7, byte8 - 25, rsinterface);
        setBoundry(++i, 25098, byte7 + 15, byte8 - 25, rsinterface);
        setBoundry(++i, 25100, byte7 - 12, byte8 - 20, rsinterface);
        setBoundry(++i, 25102, k - 2, byte9, rsinterface);
        i++;
    }
	public static void addText(int i, String s, int k, boolean l, boolean m,
			int a, TextDrawingArea[] TDA, int j) {
		RSInterface rsinterface = addTabInterface(i);
		rsinterface.parentID = i;
		rsinterface.id = i;
		rsinterface.type = 4;
		rsinterface.atActionType = 0;
		rsinterface.width = 0;
		rsinterface.height = 0;
		rsinterface.contentType = 0;
		rsinterface.aByte254 = 0;
		rsinterface.mOverInterToTrigger = a;
		rsinterface.centerText = l;
		rsinterface.textShadow = m;
		rsinterface.textDrawingAreas = TDA[j];
		rsinterface.message = s;
		rsinterface.aString228 = "";
		rsinterface.textColor = k;
	}

	public static void addPrayer(int i, int configId, int configFrame, int requiredValues, int prayerSpriteID, int hoverID, String PrayerName) {
		RSInterface Interface = addTabInterface(i);
		Interface.id = i;
		Interface.parentID = 5608;
		Interface.type = 5;
		Interface.atActionType = 4;
		Interface.contentType = 0;
		Interface.aByte254 = 0;
		Interface.mOverInterToTrigger = -1;
		Interface.sprite1 = imageLoader(0, "Prayer/PRAYERGLOW");
		Interface.sprite2 = imageLoader(1, "Prayer/PRAYERGLOW");
		Interface.width = 34;
		Interface.height = 34;
		Interface.anIntArray245 = new int[1];
		Interface.anIntArray212 = new int[1];
		Interface.anIntArray245[0] = 1;
		Interface.anIntArray212[0] = configId;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 5;
		Interface.valueIndexArray[0][1] = configFrame;
		Interface.valueIndexArray[0][2] = 0;
		Interface.tooltip = "Activate@or1@ " + PrayerName;
		Interface = addTabInterface(i + 1);
		Interface.id = i + 1;
		Interface.parentID = 5608;
		Interface.type = 5;
		Interface.atActionType = 0;
		Interface.contentType = 0;
		Interface.aByte254 = 0;
		Interface.mOverInterToTrigger = hoverID;
		Interface.sprite1 = imageLoader(prayerSpriteID, "Prayer/PRAYERON");
		Interface.sprite2 = imageLoader(prayerSpriteID, "Prayer/PRAYEROFF");
		Interface.width = 34;
		Interface.height = 34;
		Interface.anIntArray245 = new int[1];
		Interface.anIntArray212 = new int[1];
		Interface.anIntArray245[0] = 2;
		Interface.anIntArray212[0] = requiredValues + 1;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 2;
		Interface.valueIndexArray[0][1] = 5;
		Interface.valueIndexArray[0][2] = 0;
		//tooltips
		Interface = addTabInterface(hoverID);
		Interface.id = hoverID;
		Interface.parentID = 5608;
		Interface.type = 0;
		Interface.atActionType = 0;
		Interface.contentType = 0;
		Interface.aByte254 = 0;
		Interface.mOverInterToTrigger = -1;
		Interface.width = 512;
		Interface.height = 334;
		Interface.isMouseoverTriggered = true;
		addSprite(hoverID + 1, prayerSpriteID, "Prayer/PRAYERHOVER");
		setChildren(1, Interface);
		setBounds(hoverID + 1, 3, 5, 0, Interface);
	}

	public static void setBounds(int ID, int X, int Y, int frame,
			RSInterface RSinterface) {
		RSinterface.children[frame] = ID;
		RSinterface.childX[frame] = X;
		RSinterface.childY[frame] = Y;
	}

	public static void setChildren(int total, RSInterface i) {
		i.children = new int[total];
		i.childX = new int[total];
		i.childY = new int[total];
	}
	public String popupString;
	public static void addTooltipBox(int id, String text) {
		RSInterface rsi = addInterface(id);
		rsi.id = id;
		rsi.parentID = id;
		rsi.type = 8;
		rsi.popupString = text;
	}
	public static void addTooltip(int id, String text) {
		RSInterface rsi = addInterface(id);
		rsi.id = id;
		rsi.type = 0;
		rsi.isMouseoverTriggered = true;
		rsi.mOverInterToTrigger = -1;
		addTooltipBox(id + 1, text);
		rsi.totalChildren(1);
		rsi.child(0, id + 1, 0, 0);
	}

	public static void addPrayer(int i, int configId, int configFrame, int anIntArray212, int spriteID, String prayerName) {
        RSInterface tab = addTabInterface(i);
        tab.id = i;
        tab.parentID = 5608;
        tab.type = 5;
        tab.atActionType = 4;
        tab.contentType = 0;
        tab.aByte254 = 0;
        tab.mOverInterToTrigger = -1;
        tab.sprite1 = imageLoader(0, "PRAYERGLOW");
        tab.sprite2 = imageLoader(1, "PRAYERGLOW");
        tab.width = 34;
        tab.height = 34;
        tab.anIntArray245 = new int[1];
        tab.anIntArray212 = new int[1];
        tab.anIntArray245[0] = 1;
        tab.anIntArray212[0] = configId;
        tab.valueIndexArray = new int[1][3];
        tab.valueIndexArray[0][0] = 5;
        tab.valueIndexArray[0][1] = configFrame;
        tab.valueIndexArray[0][2] = 0;
        tab.tooltip = "Activate@or2@ " + prayerName;
        //tab.tooltip = "Select";
        RSInterface tab2 = addTabInterface(i + 1);
        tab2.id = i + 1;
        tab2.parentID = 5608;
        tab2.type = 5;
        tab2.atActionType = 0;
        tab2.contentType  = 0;
        tab2.aByte254 = 0;
        tab2.mOverInterToTrigger = -1;
        tab2.sprite1 = imageLoader(spriteID, "/PRAYER/PRAYON");
        tab2.sprite2 = imageLoader(spriteID, "/PRAYER/PRAYOFF");
        tab2.width = 34;
        tab2.height = 34;
        tab2.anIntArray245 = new int[1];
        tab2.anIntArray212 = new int[1];
        tab2.anIntArray245[0] = 2;
        tab2.anIntArray212[0] = anIntArray212 + 1;
        tab2.valueIndexArray = new int[1][3];
        tab2.valueIndexArray[0][0] = 2;
        tab2.valueIndexArray[0][1] = 5;
        tab2.valueIndexArray[0][2] = 0;
		//RSInterface tab3 = addTabInterface(i + 50);
    }
	//
	public static void addPrayer(int i, int configId, int configFrame, int requiredValues, int prayerSpriteID, String PrayerName, int Hover) {
		RSInterface Interface = addTabInterface(i);
		Interface.id = i;
		Interface.parentID = 22500;
		Interface.type = 5;
		Interface.atActionType = 4;
		Interface.contentType = 0;
		Interface.aByte254 = 0;
		Interface.mOverInterToTrigger = Hover;
		Interface.sprite1 = imageLoader(0, "Curses/GLOW");
		Interface.sprite2 = imageLoader(1, "Curses/GLOW");
		Interface.width = 34;
		Interface.height = 34;
		Interface.anIntArray245 = new int[1];
		Interface.anIntArray212 = new int[1];
		Interface.anIntArray245[0] = 1;
		Interface.anIntArray212[0] = configId;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 5;
		Interface.valueIndexArray[0][1] = configFrame;
		Interface.valueIndexArray[0][2] = 0;
		Interface.tooltip = "Activate@or1@ " + PrayerName;
		Interface = addTabInterface(i + 1);
		Interface.id = i + 1;
		Interface.parentID = 22500;
		Interface.type = 5;
		Interface.atActionType = 0;
		Interface.contentType  = 0;
		Interface.aByte254 = 0;
		Interface.sprite1 = imageLoader(prayerSpriteID, "Curses/PRAYON");
		Interface.sprite2 = imageLoader(prayerSpriteID, "Curses/PRAYOFF");
		Interface.width = 34;
		Interface.height = 34;
		Interface.anIntArray245 = new int[1];
		Interface.anIntArray212 = new int[1];
		Interface.anIntArray245[0] = 2;
		Interface.anIntArray212[0] = requiredValues + 1;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 2;
		Interface.valueIndexArray[0][1] = 5;
		Interface.valueIndexArray[0][2] = 0;
	}
	public static void addText(int i, String s,int k, boolean l, boolean m, int a,TextDrawingArea[] TDA, int j, int dsc) {
		RSInterface rsinterface = addTabInterface(i);
		rsinterface.parentID = i;
		rsinterface.id = i;
		rsinterface.type = 4;
		rsinterface.atActionType = 1;
		rsinterface.width = 174;
		rsinterface.height = 11;
		rsinterface.contentType = 0;
		rsinterface.aByte254 = 0;
		rsinterface.mOverInterToTrigger = a;
		rsinterface.centerText = l;
		rsinterface.textShadow = m;
		rsinterface.textDrawingAreas = TDA[j];
		rsinterface.message = s;
		rsinterface.aString228 = "";
		rsinterface.anInt219 = 0;
		rsinterface.textColor = k;
		rsinterface.anInt216 = dsc;
		rsinterface.tooltip = s;
	}

	public static void addTooltip(int id, String text, int H, int W) {
		RSInterface rsi = addTabInterface(id);
		rsi.id = id;
		rsi.type = 0;
		rsi.isMouseoverTriggered = true;
		rsi.mOverInterToTrigger = -1;
		addTooltipBox(id + 1, text);
		rsi.totalChildren(1);
		rsi.child(0, id + 1, 0, 0);
		rsi.height = H;
		rsi.width = W;
	}
	//
	public static void friendsTab(TextDrawingArea[] tda) {
        RSInterface tab = addTabInterface(5065);
        RSInterface list = interfaceCache[5066];
        addText(5067, "Friends List", tda, 1, 0xff9933, true, true);
        addText(5070, "Add Friend", tda, 0, 0xff9933, false, true);
        addText(5071, "Delete Friend", tda, 0, 0xff9933, false, true);
        addSprite(16126, 4, "Custom/Friends/SPRITE");
        addSprite(16127, 8, "Custom/Friends/SPRITE");
        addHoverButton(5068, "Custom/Friends/SPRITE", 6, 72, 32, "Add Friend", 201, 5072, 1);
        addHoveredButton(5072, "Custom/Friends/SPRITE", 7, 72, 32, 5073);
        addHoverButton(5069, "Custom/Friends/SPRITE", 6, 72, 32, "Delete Friend", 202, 5074, 1);
        addHoveredButton(5074, "Custom/Friends/SPRITE", 7, 72, 32, 5075);
        tab.totalChildren(11);
        tab.child(0, 5067, 95, 4);
        tab.child(1, 16127, 0, 25);
        tab.child(2, 16126, 0, 221);
        tab.child(3, 5066, 0, 24);
        tab.child(4, 16126, 0, 22);
        tab.child(5, 5068, 15, 226);
        tab.child(6, 5072, 15, 226);
        tab.child(7, 5069, 103, 226);
        tab.child(8, 5074, 103, 226);
        tab.child(9, 5070, 25, 237);
        tab.child(10, 5071, 106, 237);
        list.height = 196; list.width = 174;
        for(int id = 5092, i = 0; id <= 5191 && i <= 99; id++, i++) {
            list.children[i] = id; list.childX[i] = 3; list.childY[i] = list.childY[i] - 7;
        } for(int id = 5192, i = 100; id <= 5291 && i <= 199; id++, i++) {
            list.children[i] = id; list.childX[i] = 131; list.childY[i] = list.childY[i] - 7;
        }
    }

    public static void ignoreTab(TextDrawingArea[] tda) {
        RSInterface tab = addTabInterface(5715);
        RSInterface list = interfaceCache[5716];
        addText(5717, "Ignore List", tda, 1, 0xff9933, true, true);
        addText(5720, "Add Name", tda, 0, 0xff9933, false, true);
        addText(5721, "Delete Name", tda, 0, 0xff9933, false, true);
        addHoverButton(5718, "Custom/Friends/SPRITE", 6, 72, 32, "Add Name", 501, 5722, 1);
        addHoveredButton(5722, "Custom/Friends/SPRITE", 7, 72, 32, 5723);
        addHoverButton(5719, "Custom/Friends/SPRITE", 6, 72, 32, "Delete Name", 502, 5724, 1);
        addHoveredButton(5724, "Custom/Friends/SPRITE", 7, 72, 32, 5725);
        tab.totalChildren(11);
        tab.child(0, 5717, 95, 4);
        tab.child(1, 16127, 0, 25);
        tab.child(2, 16126, 0, 221);
        tab.child(3, 5716, 0, 24);
        tab.child(4, 16126, 0, 22);
        tab.child(5, 5718, 15, 226);
        tab.child(6, 5722, 15, 226);
        tab.child(7, 5719, 103, 226);
        tab.child(8, 5724, 103, 226);
        tab.child(9, 5720, 27, 237);
        tab.child(10, 5721, 108, 237);
        list.height = 196;
        list.width = 174;
        for(int id = 5742, i = 0; id <= 5841 && i <= 99; id++, i++) {
            list.children[i] = id; list.childX[i] = 3; list.childY[i] = list.childY[i] - 7;
        }
    }

		private static Sprite CustomSpriteLoader(int id, String s)
    {
        long l = (TextClass.method585(s) << 8) + (long)id;
        Sprite sprite = (Sprite)aMRUNodes_238.insertFromCache(l);
        if(sprite != null) { return sprite; }
        try {
            sprite = new Sprite("/Attack/"+id + s);
            aMRUNodes_238.removeFromCache(sprite, l);
        } catch(Exception exception) { 
			return null; }
        return sprite;
    }

    public static RSInterface addInterface(int id)
    {
        RSInterface rsi = interfaceCache[id] = new RSInterface();
        rsi.id = id;
        rsi.parentID = id;
        rsi.width = 512;
        rsi.height = 334;
        return rsi;
    }

    public static void addText(int id, String text, TextDrawingArea tda[], int idx, int color, boolean centered) {
        RSInterface rsi = interfaceCache[id] = new RSInterface();
        if(centered)
          rsi.centerText = true;
        rsi.textShadow = true;
        rsi.textDrawingAreas = tda[idx];
        rsi.message = text;
        rsi.textColor = color;
        rsi.id = id;
        rsi.type = 4;
    }

    public static void textColor(int id, int color)
    { RSInterface rsi = interfaceCache[id]; rsi.textColor = color; }

    public static void textSize(int id, TextDrawingArea tda[], int idx)
    { RSInterface rsi = interfaceCache[id]; rsi.textDrawingAreas = tda[idx]; }

    public static void addCacheSprite(int id, int sprite1, int sprite2, String sprites)
    {
        RSInterface rsi = interfaceCache[id] = new RSInterface();
        rsi.sprite1 = method207(sprite1, aClass44, sprites);
        rsi.sprite2 = method207(sprite2, aClass44, sprites);
        rsi.parentID = id;
        rsi.id = id;
        rsi.type = 5;
    }
    
    public static void sprite1(int id, int sprite)
    { RSInterface class9 = interfaceCache[id];
        class9.sprite1 = CustomSpriteLoader(sprite, "");
    }

    public static void addActionButton(int id, int sprite, int sprite2, int width, int height, String s)
    {
        RSInterface rsi = interfaceCache[id] = new RSInterface();
        rsi.sprite1 = CustomSpriteLoader(sprite, "");
        if (sprite2 == sprite)
          rsi.sprite2 = CustomSpriteLoader(sprite, "a");
        else
          rsi.sprite2 = CustomSpriteLoader(sprite2, "");
        rsi.tooltip = s;
        rsi.contentType = 0;
        rsi.atActionType = 1;
        rsi.width = width;
        rsi.mOverInterToTrigger = 52;
        rsi.parentID = id;
        rsi.id = id;
        rsi.type = 5;
        rsi.height = height;
    }

    public static void addToggleButton(int id, int sprite, int setconfig, int width, int height, String s)
    {
        RSInterface rsi = addInterface(id);
        rsi.sprite1 = CustomSpriteLoader(sprite, "");
        rsi.sprite2 = CustomSpriteLoader(sprite, "a");
        rsi.anIntArray212 = new int[1];
        rsi.anIntArray212[0] = 1;
        rsi.anIntArray245 = new int[1];
        rsi.anIntArray245[0] = 1;
        rsi.valueIndexArray = new int[1][3];
        rsi.valueIndexArray[0][0] = 5;
        rsi.valueIndexArray[0][1] = setconfig;
        rsi.valueIndexArray[0][2] = 0;
        rsi.atActionType = 4;
        rsi.width = width;
        rsi.mOverInterToTrigger = -1;
        rsi.parentID = id;
        rsi.id = id;
        rsi.type = 5;
        rsi.height = height;
        rsi.tooltip = s;
    }

    public void totalChildren(int id, int x, int y)
    { children = new int[id]; childX = new int[x]; childY = new int[y]; }

    public static void removeSomething(int id)
    { RSInterface rsi = interfaceCache[id] = new RSInterface(); }
	
	public void specialBar(int id) //7599
    {
        /*addActionButton(ID, SpriteOFF, SpriteON, Width, Height, "SpriteText");*/
            addActionButton(id-12, 7587, -1, 150, 26, "Use @gre@Special Attack");
        /*removeSomething(ID);*/
        for (int i = id-11; i < id; i++)
            removeSomething(i);

        RSInterface rsi = interfaceCache[id-12];
            rsi.width = 150;
            rsi.height = 26;

        rsi = interfaceCache[id];
            rsi.width = 150;
            rsi.height = 26;

            rsi.child(0, id-12, 0, 0);

            rsi.child(12, id+1, 3, 7);

            rsi.child(23, id+12, 16, 8);

        for (int i = 13; i < 23; i++) {
            rsi.childY[i] -= 1;
        }

        rsi = interfaceCache[id+1];
            rsi.type = 5;
            rsi.sprite1 = CustomSpriteLoader(7600, "");

        for (int i = id+2; i < id+12; i++) {
        rsi = interfaceCache[i];
            rsi.type = 5;
        }

        sprite1(id+2, 7601);sprite1(id+3, 7602);
        sprite1(id+4, 7603);sprite1(id+5, 7604);
        sprite1(id+6, 7605);sprite1(id+7, 7606);
        sprite1(id+8, 7607);sprite1(id+9, 7608);
        sprite1(id+10, 7609);sprite1(id+11, 7610);
    }

    public static void Sidebar0(TextDrawingArea[] tda)
    {
        /*Sidebar0a(id, id2, id3, "text1", "text2", "text3", "text4", str1x, str1y, str2x, str2y, str3x, str3y, str4x, str4y, img1x, img1y, img2x, img2y, img3x, img3y, img4x, img4y, tda);*/
            Sidebar0a(1698, 1701, 7499, "Chop", "Hack", "Smash", "Block", 42, 75, 127, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
            Sidebar0a(2276, 2279, 7574, "Stab", "Lunge", "Slash", "Block", 43, 75, 124, 75, 41, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
            Sidebar0a(2423, 2426, 7599, "Chop", "Slash", "Lunge", "Block", 42, 75, 125, 75, 40, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
            Sidebar0a(3796, 3799, 7624, "Pound", "Pummel", "Spike", "Block", 39, 75, 121, 75, 41, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
            Sidebar0a(4679, 4682, 7674, "Lunge", "Swipe", "Pound", "Block", 40, 75, 124, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
            Sidebar0a(4705, 4708, 7699, "Chop", "Slash", "Smash", "Block", 42, 75, 125, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
            Sidebar0a(5570, 5573, 7724, "Spike", "Impale", "Smash", "Block", 41, 75, 123, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
            Sidebar0a(7762, 7765, 7800, "Chop", "Slash", "Lunge", "Block", 42, 75, 125, 75, 40, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
        /*Sidebar0b(id, id2, "text1", "text2", "text3", "text4", str1x, str1y, str2x, str2y, str3x, str3y, str4x, str4y, img1x, img1y, img2x, img2y, img3x, img3y, img4x, img4y, tda);*/
            Sidebar0b(776, 779, "Reap", "Chop", "Jab", "Block", 42, 75, 126, 75, 46, 128, 125, 128, 122, 103, 122, 50, 40, 103, 40, 50, tda);
        /*Sidebar0c(id, id2, id3, "text1", "text2", "text3", str1x, str1y, str2x, str2y, str3x, str3y, img1x, img1y, img2x, img2y, img3x, img3y, tda);*/
            Sidebar0c(425, 428, 7474, "Pound", "Pummel", "Block", 39, 75, 121, 75, 42, 128, 40, 103, 40, 50, 122, 50, tda);
            Sidebar0c(1749, 1752, 7524, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29, 128, 40, 103, 40, 50, 122, 50, tda);
            Sidebar0c(1764, 1767, 7549, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29, 128, 40, 103, 40, 50, 122, 50, tda);
            Sidebar0c(4446, 4449, 7649, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29, 128, 40, 103, 40, 50, 122, 50, tda);
            Sidebar0c(5855, 5857, 7749, "Punch", "Kick", "Block", 40, 75, 129, 75, 42, 128, 40, 50, 122, 50, 40, 103, tda);
            Sidebar0c(6103, 6132, 6117, "Bash", "Pound", "Block", 43, 75, 124, 75, 42, 128, 40, 103, 40, 50, 122, 50, tda);
            Sidebar0c(8460, 8463, 8493, "Jab", "Swipe", "Fend", 46, 75, 124, 75, 43, 128, 40, 103, 40, 50, 122, 50, tda);
            Sidebar0c(12290, 12293, 12323, "Flick", "Lash", "Deflect", 44, 75, 127, 75, 36, 128, 40, 50, 40, 103, 122, 50, tda);
        /*Sidebar0d(id, id2, "text1", "text2", "text3", str1x, str1y, str2x, str2y, str3x, str3y, img1x, img1y, img2x, img2y, img3x, img3y, tda);*/
            Sidebar0d(328, 331, "Bash", "Pound", "Focus", 42, 66, 39, 101, 41, 136, 40, 120, 40, 50, 40, 85, tda);

        RSInterface rsi = addInterface(19300);
        /*textSize(ID, wid, Size);*/
            textSize(3983, tda, 0);
        /*addToggleButton(id, sprite, config, width, height, wid);*/
            addToggleButton(150, 150, 172, 150, 44, "Auto Retaliate");

        rsi.totalChildren(2, 2, 2);
            rsi.child(0, 3983, 52, 25); //combat level
            rsi.child(1, 150, 21, 153); //auto retaliate

        rsi = interfaceCache[3983];
            rsi.centerText = true;
            rsi.textColor = 0xff981f;
    }

    public static void Sidebar0a(int id, int id2, int id3, String text1, String text2, String text3, String text4,
                                               int str1x, int str1y, int str2x, int str2y, int str3x, int str3y, int str4x, int str4y,
                                               int img1x, int img1y, int img2x, int img2y, int img3x, int img3y, int img4x, int img4y, TextDrawingArea[] tda) //4button spec
    {
        RSInterface rsi = addInterface(id); //2423
        /*addText(ID, "Text", tda, Size, Colour, Centered);*/
            addText(id2, "-2", tda, 3, 0xff981f, true); //2426
            addText(id2+11, text1, tda, 0, 0xff981f, false);
            addText(id2+12, text2, tda, 0, 0xff981f, false);
            addText(id2+13, text3, tda, 0, 0xff981f, false);
            addText(id2+14, text4, tda, 0, 0xff981f, false);
        /*specialBar(ID);*/
            rsi.specialBar(id3); //7599

            rsi.width = 190;
            rsi.height = 261;

        int last = 15; int frame = 0;
        rsi.totalChildren(last, last, last);

            rsi.child(frame, id2+3, 21, 46); frame++; //2429
            rsi.child(frame, id2+4, 104, 99); frame++; //2430
            rsi.child(frame, id2+5, 21, 99); frame++; //2431
            rsi.child(frame, id2+6, 105, 46); frame++; //2432

            rsi.child(frame, id2+7, img1x, img1y); frame++; //bottomright 2433
            rsi.child(frame, id2+8, img2x, img2y); frame++; //topleft 2434
            rsi.child(frame, id2+9, img3x, img3y); frame++; //bottomleft 2435
            rsi.child(frame, id2+10, img4x, img4y); frame++; //topright 2436

            rsi.child(frame, id2+11, str1x, str1y); frame++; //chop 2437
            rsi.child(frame, id2+12, str2x, str2y); frame++; //slash 2438
            rsi.child(frame, id2+13, str3x, str3y); frame++; //lunge 2439
            rsi.child(frame, id2+14, str4x, str4y); frame++; //block 2440

            rsi.child(frame, 19300, 0, 0); frame++; //stuffs
            rsi.child(frame, id2, 94, 4); frame++; //weapon 2426
            rsi.child(frame, id3, 21, 205); frame++; //special attack 7599

        for (int i = id2+3; i < id2+7; i++) { //2429 - 2433
        rsi = interfaceCache[i];
            rsi.sprite1 = CustomSpriteLoader(19301, ""); rsi.sprite2 = CustomSpriteLoader(19301, "a");
            rsi.width = 68; rsi.height = 44;
        }
    }

    public static void Sidebar0b(int id, int id2, String text1, String text2, String text3, String text4,
                                               int str1x, int str1y, int str2x, int str2y, int str3x, int str3y, int str4x, int str4y,
                                               int img1x, int img1y, int img2x, int img2y, int img3x, int img3y, int img4x, int img4y, TextDrawingArea[] tda) //4button nospec
    {
        RSInterface rsi = addInterface(id); //2423
        /*addText(ID, "Text", tda, Size, Colour, Centered);*/
            addText(id2, "-2", tda, 3, 0xff981f, true); //2426
            addText(id2+11, text1, tda, 0, 0xff981f, false);
            addText(id2+12, text2, tda, 0, 0xff981f, false);
            addText(id2+13, text3, tda, 0, 0xff981f, false);
            addText(id2+14, text4, tda, 0, 0xff981f, false);

            rsi.width = 190;
            rsi.height = 261;

        int last = 14; int frame = 0;
        rsi.totalChildren(last, last, last);

            rsi.child(frame, id2+3, 21, 46); frame++; //2429
            rsi.child(frame, id2+4, 104, 99); frame++; //2430
            rsi.child(frame, id2+5, 21, 99); frame++; //2431
            rsi.child(frame, id2+6, 105, 46); frame++; //2432

            rsi.child(frame, id2+7, img1x, img1y); frame++; //bottomright 2433
            rsi.child(frame, id2+8, img2x, img2y); frame++; //topleft 2434
            rsi.child(frame, id2+9, img3x, img3y); frame++; //bottomleft 2435
            rsi.child(frame, id2+10, img4x, img4y); frame++; //topright 2436

            rsi.child(frame, id2+11, str1x, str1y); frame++; //chop 2437
            rsi.child(frame, id2+12, str2x, str2y); frame++; //slash 2438
            rsi.child(frame, id2+13, str3x, str3y); frame++; //lunge 2439
            rsi.child(frame, id2+14, str4x, str4y); frame++; //block 2440

            rsi.child(frame, 19300, 0, 0); frame++; //stuffs
            rsi.child(frame, id2, 94, 4); frame++; //weapon 2426

        for (int i = id2+3; i < id2+7; i++) { //2429 - 2433
        rsi = interfaceCache[i];
            rsi.sprite1 = CustomSpriteLoader(19301, ""); rsi.sprite2 = CustomSpriteLoader(19301, "a");
            rsi.width = 68; rsi.height = 44;
        }
    }

    public static void Sidebar0c(int id, int id2, int id3, String text1, String text2, String text3,
                                               int str1x, int str1y, int str2x, int str2y, int str3x, int str3y,
                                               int img1x, int img1y, int img2x, int img2y, int img3x, int img3y, TextDrawingArea[] tda) //3button spec
    {
        RSInterface rsi = addInterface(id); //2423
        /*addText(ID, "Text", tda, Size, Colour, Centered);*/
            addText(id2, "-2", tda, 3, 0xff981f, true); //2426
            addText(id2+9, text1, tda, 0, 0xff981f, false);
            addText(id2+10, text2, tda, 0, 0xff981f, false);
            addText(id2+11, text3, tda, 0, 0xff981f, false);
        /*specialBar(ID);*/
            rsi.specialBar(id3); //7599

            rsi.width = 190;
            rsi.height = 261;

        int last = 12; int frame = 0;
        rsi.totalChildren(last, last, last);

            rsi.child(frame, id2+3, 21, 99); frame++;
            rsi.child(frame, id2+4, 105, 46); frame++;
            rsi.child(frame, id2+5, 21, 46); frame++;

            rsi.child(frame, id2+6, img1x, img1y); frame++; //topleft
            rsi.child(frame, id2+7, img2x, img2y); frame++; //bottomleft
            rsi.child(frame, id2+8, img3x, img3y); frame++; //topright

            rsi.child(frame, id2+9, str1x, str1y); frame++; //chop
            rsi.child(frame, id2+10, str2x, str2y); frame++; //slash
            rsi.child(frame, id2+11, str3x, str3y); frame++; //lunge

            rsi.child(frame, 19300, 0, 0); frame++; //stuffs
            rsi.child(frame, id2, 94, 4); frame++; //weapon
            rsi.child(frame, id3, 21, 205); frame++; //special attack 7599

        for (int i = id2+3; i < id2+6; i++) {
        rsi = interfaceCache[i];
            rsi.sprite1 = CustomSpriteLoader(19301, ""); rsi.sprite2 = CustomSpriteLoader(19301, "a");
            rsi.width = 68; rsi.height = 44;
        }
    }

    public static void Sidebar0d(int id, int id2, String text1, String text2, String text3,
                                               int str1x, int str1y, int str2x, int str2y, int str3x, int str3y,
                                               int img1x, int img1y, int img2x, int img2y, int img3x, int img3y, TextDrawingArea[] tda) //3button nospec (magic intf)
    {
        RSInterface rsi = addInterface(id); //2423
        /*addText(ID, "Text", tda, Size, Colour, Centered);*/
            addText(id2, "-2", tda, 3, 0xff981f, true); //2426
            addText(id2+9, text1, tda, 0, 0xff981f, false);
            addText(id2+10, text2, tda, 0, 0xff981f, false);
            addText(id2+11, text3, tda, 0, 0xff981f, false);

            //addText(353, "Spell", tda, 0, 0xff981f, false);
			removeSomething(353);
            addText(354, "Spell", tda, 0, 0xff981f, false);

            addCacheSprite(337, 19, 0, "combaticons");
            addCacheSprite(338, 13, 0, "combaticons2");
            addCacheSprite(339, 14, 0, "combaticons2");

        /*addToggleButton(id, sprite, config, width, height, tooltip);*/
            //addToggleButton(349, 349, 108, 68, 44, "Select");
			removeSomething(349);
            addToggleButton(350, 350, 108, 68, 44, "Select");

            rsi.width = 190;
            rsi.height = 261;

			int last = 15; int frame = 0;
			rsi.totalChildren(last, last, last);

            rsi.child(frame, id2+3, 20, 115); frame++;
            rsi.child(frame, id2+4, 20, 80); frame++;
            rsi.child(frame, id2+5, 20, 45); frame++;

            rsi.child(frame, id2+6, img1x, img1y); frame++; //topleft
            rsi.child(frame, id2+7, img2x, img2y); frame++; //bottomleft
            rsi.child(frame, id2+8, img3x, img3y); frame++; //topright

            rsi.child(frame, id2+9, str1x, str1y); frame++; //bash
            rsi.child(frame, id2+10, str2x, str2y); frame++; //pound
            rsi.child(frame, id2+11, str3x, str3y); frame++; //focus

            rsi.child(frame, 349, 105, 46); frame++; //spell1
            rsi.child(frame, 350, 104, 106); frame++; //spell2

            rsi.child(frame, 353, 125, 74); frame++; //spell
            rsi.child(frame, 354, 125, 134); frame++; //spell

            rsi.child(frame, 19300, 0, 0); frame++; //stuffs
            rsi.child(frame, id2, 94, 4); frame++; //weapon
    }
	

	public static void emoteTab() {
        RSInterface tab = addTabInterface(147);
        RSInterface scroll = addTabInterface(148);
        tab.totalChildren(1);
        tab.child(0, 148, 0, 1);
        addButton(168, 0, "Custom/Emotes/EMOTE", "Yes",41,47);
        addButton(169, 1, "Custom/Emotes/EMOTE", "No",41,47);
        addButton(164, 2, "Custom/Emotes/EMOTE", "Bow",41,47);
        addButton(165, 3, "Custom/Emotes/EMOTE", "Angry",41,47);
        addButton(162, 4, "Custom/Emotes/EMOTE", "Think",41,47);
        addButton(163, 5, "Custom/Emotes/EMOTE", "Wave",41,47);
        addButton(13370, 6, "Custom/Emotes/EMOTE", "Shrug",41,47);
        addButton(171, 7, "Custom/Emotes/EMOTE", "Cheer",41,47);
        addButton(167, 8, "Custom/Emotes/EMOTE", "Beckon",41,47);
        addButton(170, 9, "Custom/Emotes/EMOTE", "Laugh",41,47);
        addButton(13366, 10, "Custom/Emotes/EMOTE", "Jump for Joy",41,47);
        addButton(13368, 11, "Custom/Emotes/EMOTE", "Yawn",41,47);
        addButton(166, 12, "Custom/Emotes/EMOTE", "Dance",41,47);
        addButton(13363, 13, "Custom/Emotes/EMOTE", "Jig",41,47);
        addButton(13364, 14, "Custom/Emotes/EMOTE", "Spin",41,47);
        addButton(13365, 15, "Custom/Emotes/EMOTE", "Headbang",41,47);
        addButton(161, 16, "Custom/Emotes/EMOTE", "Cry",41,47);
        addButton(11100, 17, "Custom/Emotes/EMOTE", "Blow kiss",41,47);
        addButton(13362, 18, "Custom/Emotes/EMOTE", "Panic",41,47);
        addButton(13367, 19, "Custom/Emotes/EMOTE", "Raspberry",41,47);
        addButton(172, 20, "Custom/Emotes/EMOTE", "Clap",41,47);
        addButton(13369, 21, "Custom/Emotes/EMOTE", "Salute",41,47);
        addButton(13383, 22, "Custom/Emotes/EMOTE", "Goblin Bow",41,47);
        addButton(13384, 23, "Custom/Emotes/EMOTE", "Goblin Salute",41,47);
        addButton(667, 24, "Custom/Emotes/EMOTE", "Glass Box",41,47);
        addButton(6503, 25, "Custom/Emotes/EMOTE", "Climb Rope",41,47);
        addButton(6506, 26, "Custom/Emotes/EMOTE", "Lean On Air",41,47);
        addButton(666, 27, "Custom/Emotes/EMOTE", "Glass Wall",41,47);
        addButton(18464, 28, "Custom/Emotes/EMOTE", "Zombie Walk",41,47);
        addButton(18465, 29, "Custom/Emotes/EMOTE", "Zombie Dance",41,47);
        addButton(15166, 30, "Custom/Emotes/EMOTE", "Scared",41,47);
        addButton(18686, 31, "Custom/Emotes/EMOTE", "Rabbit Hop",41,47);
		addButton(154, 32, "Custom/Emotes/EMOTE", "Skillcape Emote",41,47);
        scroll.totalChildren(33);
        scroll.child(0, 168, 10, 7);
        scroll.child(1, 169, 54, 7);
        scroll.child(2, 164, 98, 14);
        scroll.child(3, 165, 137, 7);
        scroll.child(4, 162, 9, 56);
        scroll.child(5, 163, 48, 56);
        scroll.child(6, 13370, 95, 56);
        scroll.child(7, 171, 137, 56);
        scroll.child(8, 167, 7, 105);
        scroll.child(9, 170, 51, 105);
        scroll.child(10, 13366, 95, 104);
        scroll.child(11, 13368, 139, 105);
        scroll.child(12, 166, 6, 154);
        scroll.child(13, 13363, 50, 154);
        scroll.child(14, 13364, 90, 154);
        scroll.child(15, 13365, 135, 154);
        scroll.child(16, 161, 8, 204);
        scroll.child(17, 11100, 51, 203);
        scroll.child(18, 13362, 99, 204);
        scroll.child(19, 13367, 137, 203);
        scroll.child(20, 172, 10, 253);
        scroll.child(21, 13369, 53, 253);
        scroll.child(22, 13383, 88, 258);
        scroll.child(23, 13384, 138, 252);
        scroll.child(24, 667, 2, 303);
        scroll.child(25, 6503, 49, 302);
        scroll.child(26, 6506, 93, 302);
        scroll.child(27, 666, 137, 302);
        scroll.child(28, 18464, 9, 352);
        scroll.child(29, 18465, 50, 352);
        scroll.child(30, 15166, 94, 356);
        scroll.child(31, 18686, 141, 353);
        scroll.child(32, 154, 5, 401);
        scroll.width = 173; scroll.height = 258; scroll.scrollMax = 450;
    }
	
	public static void addToggleButton(int id, int bID, int bID2, String bName, String tT, int configID, int aT, int configFrame) {
		RSInterface tab = addTabInterface(id);
		tab.parentID = id;
		tab.id = id;
		tab.type = 5;
		tab.atActionType = aT;
		tab.contentType = 0;//anInt214
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = -1;//anInt230
		tab.anIntArray245 = new int[1];
		tab.anIntArray212 = new int[1];
		tab.anIntArray245[0] = 1;
		tab.anIntArray212[0] = configID;
		tab.valueIndexArray = new int[1][3];
		tab.valueIndexArray[0][0] = 5;
		tab.valueIndexArray[0][1] = configFrame;
		tab.valueIndexArray[0][2] = 0;
		tab.sprite1 = imageLoader(bID, bName);
		tab.sprite2 = imageLoader(bID2, bName);
		tab.width = tab.sprite1.myWidth;
		tab.height = tab.sprite1.myHeight;
		tab.tooltip = tT;
	}
	
	public static void audioOptions(TextDrawingArea tda[]) {
		RSInterface rsinterface = addInterface(40010);
        int i = 0;
        byte byte0 = 2;
        addSprite(40024, 19, "/Options/OPTION");
		addHover(40025, 3, 0, 40026, 20, "/Options/OPTION", 16, 16, "Close Window");
		addHovered(40026, 21, "/Options/OPTION", 16, 16, 40027);
        addText(40028, "Audio Options", tda, 2, 0xff9b00, true, true);
        addConfigButton(930, 904, 19, 24, "/Options/SPRITE", 26, 16, "Select", 4, 5, 168);
        addConfigButton(931, 904, 20, 25, "/Options/SPRITE", 26, 16, "Select", 3, 5, 168);
        addConfigButton(932, 904, 21, 26, "/Options/SPRITE", 26, 16, "Select", 2, 5, 168);
        addConfigButton(933, 904, 22, 27, "/Options/SPRITE", 26, 16, "Select", 1, 5, 168);
        addConfigButton(934, 904, 23, 28, "/Options/SPRITE", 24, 16, "Select", 0, 5, 168);
		
        addConfigButton(40011, 904, 19, 24, "/Options/SPRITE", 26, 16, "Select", 4, 5, 169);
        addConfigButton(40012, 904, 20, 25, "/Options/SPRITE", 26, 16, "Select", 3, 5, 169);
        addConfigButton(40013, 904, 21, 26, "/Options/SPRITE", 26, 16, "Select", 2, 5, 169);
        addConfigButton(40014, 904, 22, 27, "/Options/SPRITE", 26, 16, "Select", 1, 5, 169);
        addConfigButton(40015, 904, 23, 28, "/Options/SPRITE", 24, 16, "Select", 0, 5, 169);
		
        addConfigButton(40016, 904, 19, 24, "/Options/SPRITE", 26, 16, "Select", 4, 5, 400);
        addConfigButton(40017, 904, 20, 25, "/Options/SPRITE", 26, 16, "Select", 3, 5, 400);
        addConfigButton(40018, 904, 21, 26, "/Options/SPRITE", 26, 16, "Select", 2, 5, 400);
        addConfigButton(40019, 904, 22, 27, "/Options/SPRITE", 26, 16, "Select", 1, 5, 400);
        addConfigButton(40020, 904, 23, 28, "/Options/SPRITE", 24, 16, "Select", 0, 5, 400);
		
        addSprite(40021, 3, "/Options/OPTION");
        addSprite(40022, 5, "/Options/OPTION");
        addSprite(40023, 7, "/Options/OPTION");
		
        rsinterface.totalChildren(22);
        rsinterface.child(0, 40024, 190, 55 + byte0);
        rsinterface.child(1, 930, 205, 120 + byte0);
        rsinterface.child(2, 931, 229, 120 + byte0);
        rsinterface.child(3, 932, 254, 120 + byte0);
        rsinterface.child(4, 933, 280, 120 + byte0);
        rsinterface.child(5, 934, 305, 120 + byte0);
		
        rsinterface.child(6, 40011, 205, 175 + byte0);
        rsinterface.child(7, 40012, 229, 175 + byte0);
        rsinterface.child(8, 40013, 254, 175 + byte0);
        rsinterface.child(9, 40014, 280, 175 + byte0);
        rsinterface.child(10, 40015, 305, 175 + byte0);
		
        rsinterface.child(11, 40016, 205, 230 + byte0);
        rsinterface.child(12, 40017, 229, 230 + byte0);
        rsinterface.child(13, 40018, 254, 230 + byte0);
        rsinterface.child(14, 40019, 280, 230 + byte0);
        rsinterface.child(15, 40020, 305, 230 + byte0);
		
        rsinterface.child(16, 40021, 250, 85);
        rsinterface.child(17, 40022, 250, 141);
        rsinterface.child(18, 40023, 250, 197);
		
        rsinterface.child(19, 40025, 315, 60);
        rsinterface.child(20, 40026, 315, 60);
        rsinterface.child(21, 40028, 264, 60);
	}
	public static void vidOptions(TextDrawingArea tda[]) {
		RSInterface rsinterface = addInterface(40030);
        int i = 0;
        byte byte0 = 2;
        addSprite(40042, 24, "/Options/OPTION");
		addHover(40039, 3, 0, 40026, 20, "/Options/OPTION", 16, 16, "Close Window");
		addHovered(40040, 21, "/Options/OPTION", 16, 16, 40027);
        addText(40041, "Graphics Options", tda, 2, 0xff9b00, true, true);
        addConfigButton(906, 904, 10, 14, "/Options/SPRITE", 32, 16, "Dark", 1, 5, 166);
        addConfigButton(908, 904, 11, 15, "/Options/SPRITE", 32, 16, "Normal", 2, 5, 166);
        addConfigButton(910, 904, 12, 16, "/Options/SPRITE", 32, 16, "Bright", 3, 5, 166);
        addConfigButton(912, 904, 13, 17, "/Options/SPRITE", 32, 16, "Very Bright", 4, 5, 166);
		
        addConfigButton(941, 904, 19, 24, "/Options/SPRITE", 26, 16, "Regular Zoom", 4, 5, 169);
        addConfigButton(942, 904, 20, 25, "/Options/SPRITE", 26, 16, "Zoom +1", 3, 5, 169);
        addConfigButton(943, 904, 21, 26, "/Options/SPRITE", 26, 16, "Zoom +2", 2, 5, 169);
        addConfigButton(944, 904, 22, 27, "/Options/SPRITE", 26, 16, "Zoom +3", 1, 5, 169);
        addConfigButton(945, 904, 23, 28, "/Options/SPRITE", 24, 16, "Zoom +4", 0, 5, 169);
		
        addSprite(40036, 9, "/Options/SPRITE");
        addSprite(40037, 29, "/Options/SPRITE");
		
		addHover(40043, 1, 0, 40043, 37, "/Options/SPRITE", 50, 39, "Fixed");
		addHovered(40044, 38, "/Options/SPRITE", 50, 39, 40046);
		addHover(40046, 1, 0, 40046, 39, "/Options/SPRITE", 50, 39, "Resizable");
		addHovered(40047, 40, "/Options/SPRITE", 50, 39, 40048);
		addHover(40049, 1, 0, 40049, 41, "/Options/SPRITE", 50, 39, "Fullscreen");
		addHovered(40050, 42, "/Options/SPRITE", 50, 39, 40051);
		
        rsinterface.totalChildren(21);
        rsinterface.child(0, 40042, 25, 75 + byte0);
        rsinterface.child(1, 906, 125, 140 + byte0);
        rsinterface.child(2, 908, 149, 140 + byte0);
        rsinterface.child(3, 910, 174, 140 + byte0);
        rsinterface.child(4, 912, 200, 140 + byte0);
		
        rsinterface.child(5, 941, 245, 140 + byte0);
        rsinterface.child(6, 942, 269, 140 + byte0);
        rsinterface.child(7, 943, 294, 140 + byte0);
        rsinterface.child(8, 944, 320, 140 + byte0);
        rsinterface.child(9, 945, 345, 140 + byte0);
		
        rsinterface.child(10, 40036, 160, 105);
        rsinterface.child(11, 40037, 290, 105);
		
        rsinterface.child(12, 40039, 450, 80);
        rsinterface.child(13, 40040, 450, 80);
        rsinterface.child(14, 40041, 250, 80);
		
        rsinterface.child(15, 40043, 145, 180);
        rsinterface.child(16, 40044, 145, 180);
        rsinterface.child(17, 40046, 220, 180);
        rsinterface.child(18, 40047, 220, 180);
        rsinterface.child(19, 40049, 295, 180);
        rsinterface.child(20, 40050, 295, 180);
	}
		

    public static void optionTab(TextDrawingArea tda[]) {
        RSInterface rsinterface = addTabInterface(904);
        RSInterface rsinterface1 = interfaceCache[149];
        rsinterface1.textColor = 0xff9933;
        addSprite(907, 18, "/Options/SPRITE");
        addSprite(909, 29, "/Options/SPRITE");
        addSprite(951, 32, "/Options/SPRITE");
        addSprite(953, 33, "/Options/SPRITE");
        addSprite(955, 34, "/Options/SPRITE");
        addSprite(947, 36, "/Options/SPRITE");
        addSprite(949, 35, "/Options/SPRITE");
        addSprite(40001, 4, "/Options/SPRITE");
        addSprite(40002, 4, "/Options/SPRITE");
        addConfigButton(152, 904, 30, 31, "/Options/SPRITE", 40, 40, "Toggle-run", 1, 5, 173);
        addConfigButton(913, 904, 30, 31, "/Options/SPRITE", 40, 40, "Toggle-Mouse Buttons", 0, 5, 170);
        addConfigButton(915, 904, 30, 31, "/Options/SPRITE", 40, 40, "Toggle-Chat Effects", 0, 5, 171);
        addConfigButton(957, 904, 30, 31, "/Options/SPRITE", 40, 40, "Toggle-Split Private Chat", 1, 5, 287);
        addConfigButton(12464, 904, 30, 31, "/Options/SPRITE", 40, 40, "Toggle-Accept Aid", 0, 5, 427);
		addButton(40004, 22, "/Options/OPTION", "Graphics Options");
		addButton(40005, 23, "/Options/OPTION", "Audio Options");
        addText(40003, "Options", tda, 1, 0xff9b00, true, true);
        rsinterface.totalChildren(16);
        rsinterface.child(0, 913, 15, 153);
        rsinterface.child(1, 955, 19, 159);
        rsinterface.child(2, 915, 75, 153);
        rsinterface.child(3, 953, 79, 160);
        rsinterface.child(4, 957, 135, 153);
        rsinterface.child(5, 951, 139, 159);
        rsinterface.child(6, 12464, 45, 208);
        rsinterface.child(7, 949, 50, 213);
        rsinterface.child(8, 152, 105, 208);
        rsinterface.child(9, 947, 117, 212);
        rsinterface.child(10, 149, 113, 231);
        rsinterface.child(11, 40001, 0, 30);
        rsinterface.child(12, 40002, 0, 100);
        rsinterface.child(13, 40003, 93, 8);
        rsinterface.child(14, 40004, 35, 47);
        rsinterface.child(15, 40005, 110,47);
    }
	
	public static void clanChatTab(TextDrawingArea[] tda) {
        RSInterface tab = addTabInterface(18128);
        addHoverButton(18129, "Custom/Clan Chat/SPRITE", 6, 72, 32, "Join Chat", 550, 18130, 1);
        addHoveredButton(18130, "Custom/Clan Chat/SPRITE", 7, 72, 32, 18131);
        addHoverButton(18132, "Custom/Clan Chat/SPRITE", 6, 72, 32, "Leave Chat", -1, 18133, 5);
        addHoveredButton(18133, "Custom/Clan Chat/SPRITE", 7, 72, 32, 18134);
		addButton(18250, 0, "Custom/Clan Chat/Lootshare", "Toggle lootshare");
        addText(18135, "Join Chat", tda, 0, 0xff9b00, true, true);
        addText(18136, "Leave Chat", tda, 0, 0xff9b00, true, true);
        addSprite(18137, 37, "Custom/Clan Chat/SPRITE");
        addText(18138, "Clan Chat", tda, 1, 0xff9b00, true, true);
        addText(18139, "Talking in: Not in chat", tda, 0, 0xff9b00, false, true);
        addText(18140, "Owner: None", tda, 0, 0xff9b00, false, true);
        tab.totalChildren(14);
        tab.child(0, 16126, 0, 221);
        tab.child(1, 16126, 0, 59);
        tab.child(2, 18137, 0, 62);
        tab.child(3, 18143, 0, 62);
        tab.child(4, 18129, 15, 226);
        tab.child(5, 18130, 15, 226);
        tab.child(6, 18132, 103, 226);
        tab.child(7, 18133, 103, 226);
        tab.child(8, 18135, 51, 237);
        tab.child(9, 18136, 139, 237);
        tab.child(10, 18138, 95, 1);
        tab.child(11, 18139, 10, 23);
        tab.child(12, 18140, 25, 38);
		tab.child(13, 18250, 145,15);
        /* Text area */
        RSInterface list = addTabInterface(18143);
        list.totalChildren(100);
        for(int i = 18144; i <= 18244; i++) {
            addText(i, "", tda, 0, 0xffffff, false, true);
        }
        for(int id = 18144, i = 0; id <= 18243 && i <= 99; id++, i++) {
            list.children[i] = id; list.childX[i] = 5;
            for(int id2 = 18144, i2 = 1; id2 <= 18243 && i2<= 99; id2++, i2++) {
                list.childY[0] = 2;
                list.childY[i2] = list.childY[i2 - 1] + 14;
            }
        }
        list.height = 158; list.width = 174;
        list.scrollMax = 1405;
    }
	
	public static void Pestpanel(TextDrawingArea[] tda) {
		RSInterface RSinterface = addInterface(21119);
		addText(21120, "What", 0x999999, false, true, 52, tda, 1);
		addText(21121, "What", 0x33cc00, false, true, 52, tda, 1);
		addText(21122, "(Need 5 to 25 players)", 0xFFcc33, false, true, 52, tda, 1);
		addText(21123, "Points", 0x33ccff, false, true, 52, tda, 1);
		int last = 4;
		RSinterface.children = new int[last];
		RSinterface.childX = new int[last];
		RSinterface.childY = new int[last];
		setBounds(21120, 15, 12, 0,RSinterface);
		setBounds(21121, 15, 30, 1,RSinterface);
		setBounds(21122, 15, 48, 2,RSinterface);
		setBounds(21123, 15, 66, 3,RSinterface);
	}
		
	public static void Pestpanel2(TextDrawingArea[] tda) {
		RSInterface RSinterface = addInterface(21100);
		addSprite(21101, 0, "Custom/Pest Control/PEST1");
		addSprite(21102, 1, "Custom/Pest Control/PEST1");
		addSprite(21103, 2, "Custom/Pest Control/PEST1");
		addSprite(21104, 3, "Custom/Pest Control/PEST1");
		addSprite(21105, 4, "Custom/Pest Control/PEST1");
		addSprite(21106, 5, "Custom/Pest Control/PEST1");
		addText(21107, "", 0xCC00CC, false, true, 52, tda, 1);
		addText(21108, "", 0x0000FF, false, true, 52, tda, 1);
		addText(21109, "", 0xFFFF44, false, true, 52, tda, 1);
		addText(21110, "", 0xCC0000, false, true, 52, tda, 1);
		addText(21111, "250", 0x99FF33, false, true, 52, tda, 1);//w purp
		addText(21112, "250", 0x99FF33, false, true, 52, tda, 1);//e blue
		addText(21113, "250", 0x99FF33, false, true, 52, tda, 1);//se yel
		addText(21114, "250", 0x99FF33, false, true, 52, tda, 1);//sw red
		addText(21115, "200", 0x99FF33, false, true, 52, tda, 1);//attacks
		addText(21116, "0", 0x99FF33, false, true, 52, tda, 1);//knights hp
		addText(21117, "Time Remaining:", 0xFFFFFF, false, true, 52, tda, 0);
		addText(21118, "", 0xFFFFFF, false, true, 52, tda, 0);
		int last = 18;
		RSinterface.children = new int[last];
		RSinterface.childX = new int[last];
		RSinterface.childY = new int[last];
		setBounds(21101, 361, 26, 0,RSinterface);
		setBounds(21102, 396, 26, 1,RSinterface);
		setBounds(21103, 436, 26, 2,RSinterface);
		setBounds(21104, 474, 26, 3,RSinterface);
		setBounds(21105, 3, 21, 4,RSinterface);
		setBounds(21106, 3, 50, 5,RSinterface);
		setBounds(21107, 371, 60, 6,RSinterface);
		setBounds(21108, 409, 60, 7,RSinterface);
		setBounds(21109, 443, 60, 8,RSinterface);
		setBounds(21110, 479, 60, 9,RSinterface);
		setBounds(21111, 362, 10, 10,RSinterface);
		setBounds(21112, 398, 10, 11,RSinterface);
		setBounds(21113, 436, 10, 12,RSinterface);
		setBounds(21114, 475, 10, 13,RSinterface);
		setBounds(21115, 32, 32, 14,RSinterface);
		setBounds(21116, 32, 62, 15,RSinterface);
		setBounds(21117, 8, 88, 16,RSinterface);
		setBounds(21118, 87, 88, 17,RSinterface);
	}
	
	public String hoverText;
	public static void addHoverBox(int id, String text) {
        RSInterface rsi = interfaceCache[id];//addTabInterface(id);
        rsi.id = id;
        rsi.parentID = id;
		rsi.isMouseoverTriggered = true;
        rsi.type = 8;
        rsi.hoverText = text;
    }
	
	public static void addText(int id, String text, TextDrawingArea tda[], int idx, int color, boolean center, boolean shadow) {
		RSInterface tab = addTabInterface(id);
		tab.parentID = id;
		tab.id = id;
		tab.type = 4;
		tab.atActionType = 0;
		tab.width = 0;
		tab.height = 11;
		tab.contentType = 0;
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = -1;
		tab.centerText = center;
		tab.textShadow = shadow;
		tab.textDrawingAreas = tda[idx];
		tab.message = text;
		tab.aString228 = "";
		tab.textColor = color;
		tab.anInt219 = 0;
		tab.anInt216 = 0;
		tab.anInt239 = 0;	
	}

	public static void addButton(int id, int sid, String spriteName, String tooltip, int w, int h) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 1;
		tab.contentType = 0;
		tab.aByte254 = (byte)0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(sid, spriteName);
		tab.sprite2 = imageLoader(sid, spriteName);
		tab.width = w;
		tab.height = h;
		tab.tooltip = tooltip;
	}
	
	public static void addConfigButton(int ID, int pID, int bID, int bID2, String bName, int width, int height, String tT, int configID, int aT, int configFrame) {
        RSInterface Tab = addTabInterface(ID);
        Tab.parentID = pID;
        Tab.id = ID;
        Tab.type = 5;
        Tab.atActionType = aT;
        Tab.contentType = 0;
        Tab.width = width;
        Tab.height = height;
        Tab.aByte254 = 0;
        Tab.mOverInterToTrigger = -1;
        Tab.anIntArray245 = new int[1];
        Tab.anIntArray212 = new int[1];
        Tab.anIntArray245[0] = 1;
        Tab.anIntArray212[0] = configID;
        Tab.valueIndexArray = new int[1][3];
        Tab.valueIndexArray[0][0] = 5;
        Tab.valueIndexArray[0][1] = configFrame;
        Tab.valueIndexArray[0][2] = 0;
        Tab.sprite1 = imageLoader(bID, bName);
        Tab.sprite2 = imageLoader(bID2, bName);
        Tab.tooltip = tT;
    }

	public static void addSprite(int id, int spriteId, String spriteName) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.aByte254 = (byte)0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(spriteId, spriteName);
		tab.sprite2 = imageLoader(spriteId, spriteName); 
		tab.width = 512;
		tab.height = 334;
	}

	public static void addHoverButton(int i, String imageName, int j, int width, int height, String text, int contentType, int hoverOver, int aT) {//hoverable button
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = aT;
		tab.contentType = contentType;
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = hoverOver;
		tab.sprite1 = imageLoader(j, imageName);
		tab.sprite2 = imageLoader(j, imageName);
		tab.width = width;
		tab.height = height;
		tab.tooltip = text;
	}

	public static void addHoveredButton(int i, String imageName, int j, int w, int h, int IMAGEID) {//hoverable button
		RSInterface tab = addTabInterface(i);
		tab.parentID = i;
		tab.id = i;
		tab.type = 0;
		tab.atActionType = 0;
		tab.width = w;
		tab.height = h;
		tab.isMouseoverTriggered = true;
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = -1;
		tab.scrollMax = 0;
		addHoverImage(IMAGEID, j, j, imageName);
		tab.totalChildren(1);
		tab.child(0, IMAGEID, 0, 0);
	}

	public static void addHoverImage(int i, int j, int k, String name) {
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(j, name);
		tab.sprite2 = imageLoader(k, name);
	}

	public static RSInterface addScreenInterface(int id) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 0;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.aByte254 = (byte)0;
		tab.mOverInterToTrigger = 0;
		return tab;
	}

	public static RSInterface addTabInterface(int id) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;//250
		tab.parentID = id;//236
		tab.type = 0;//262
		tab.atActionType = 0;//217
		tab.contentType = 0;
		tab.width = 512;//220
		tab.height = 700;//267
		tab.aByte254 = (byte)0;
		tab.mOverInterToTrigger = -1;//Int 230
		return tab;
	}

	private static Sprite imageLoader(int i, String s) {
		long l = (TextClass.method585(s) << 8) + (long)i;
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if(sprite != null)
			return sprite;
		try {
			sprite = new Sprite(s+" "+i);
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch(Exception exception) {
			return null;
		}
		return sprite;
	}

	public void child(int id, int interID, int x, int y) {
		children[id] = interID;
		childX[id] = x;
		childY[id] = y;
	}
	public void totalChildren(int t) {
		children = new int[t];
		childX = new int[t];
		childY = new int[t];
	}
	public static void setBoundry(int frame, int ID, int X, int Y, RSInterface RSInterface) {
		RSInterface.children[frame] = ID;
		RSInterface.childX[frame] = X;
		RSInterface.childY[frame] = Y;
	}
	
	private Model method206(int i, int j)
	{
		Model model = (Model) aMRUNodes_264.insertFromCache((i << 16) + j);
		if(model != null)
			return model;
		if(i == 1)
			model = Model.method462(j);
		if(i == 2)
			model = EntityDef.forID(j).method160();
		if(i == 3)
			model = client.myPlayer.method453();
		if(i == 4)
			model = ItemDef.forID(j).method202(50);
		if(i == 5)
			model = null;
		if(model != null)
			aMRUNodes_264.removeFromCache(model, (i << 16) + j);
		return model;
	}

	private static Sprite method207(int i, StreamLoader streamLoader, String s) {
		long l = (TextClass.method585(s) << 8) + (long)i;
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if(sprite != null)
			return sprite;
		try {
			sprite = new Sprite(streamLoader, s, i);
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch(Exception _ex) {
			return null;
		}
		return sprite;
	}

	public static void method208(boolean flag, Model model) {
		int i = 0;//was parameter
		int j = 5;//was parameter
		if(flag)
			return;
		aMRUNodes_264.unlinkAll();
		if(model != null && j != 4)
			aMRUNodes_264.removeFromCache(model, (j << 16) + i);
	}

	public Model method209(int j, int k, boolean flag) {
		Model model;
		if(flag)
			model = method206(anInt255, anInt256);
		else
			model = method206(anInt233, mediaID);
		if(model == null)
			return null;
		if(k == -1 && j == -1 && model.anIntArray1640 == null)
			return model;
		Model model_1 = new Model(true, Class36.method532(k) & Class36.method532(j), false, model);
		if(k != -1 || j != -1)
			model_1.method469();
		if(k != -1)
			model_1.method470(k);
		if(j != -1)
			model_1.method470(j);
		model_1.method479(64, 768, -50, -10, -50, true);
			return model_1;
	}

	public RSInterface() {}

	public static StreamLoader aClass44;
	public boolean drawsTransparent;
	public Sprite sprite1;
	public int anInt208;
	public Sprite sprites[];
	public static RSInterface interfaceCache[];
	public int anIntArray212[];
	public int contentType;//anInt214
	public int spritesX[];
	public int anInt216;
	public int atActionType;
	public String spellName;
	public int anInt219;
	public int width;
	public String tooltip;
	public String selectedActionName;
	public boolean centerText;
	public int scrollPosition;
	public String actions[];
	public int valueIndexArray[][];
	public boolean aBoolean227;
	public String aString228;
	public int mOverInterToTrigger;
	public int invSpritePadX;
	public int textColor;
	public int anInt233;
	public int mediaID;
	public boolean aBoolean235;
	public int parentID;
	public int spellUsableOn;
	private static MRUNodes aMRUNodes_238;
	public int anInt239;
	public int children[];
	public int childX[];
	public boolean usableItemInterface;
	public TextDrawingArea textDrawingAreas;
	public int invSpritePadY;
	public int anIntArray245[];
	public int anInt246;
	public int spritesY[];
	public String message;
	public boolean isInventoryInterface;
	public int id;
	public int invStackSizes[];
	public int inv[];
	public byte aByte254;
	private int anInt255;
	private int anInt256;
	public int anInt257;
	public int anInt258;
	public boolean aBoolean259;
	public Sprite sprite2;
	public int scrollMax;
	public int type;
	public int anInt263;
	private static final MRUNodes aMRUNodes_264 = new MRUNodes(30);
	public int anInt265;
	public boolean isMouseoverTriggered;
	public int height;
	public boolean textShadow;
	public int modelZoom;
	public int modelRotation1;
	public int modelRotation2;
	public int childY[];

		public static void addButton(int id, int sid, String spriteName, String tooltip, int mOver, int atAction, int width, int height) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = atAction;
		tab.contentType = 0;
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = mOver;
		tab.sprite1 = imageLoader(sid, spriteName);
		tab.sprite2 = imageLoader(sid, spriteName);
		tab.width = width;
		tab.height = height;
		tab.tooltip = tooltip;
		tab.inventoryhover = true;
	}
	public boolean inventoryhover;
		public static void EquipmentTab(TextDrawingArea[] tda) {
		RSInterface Interface = interfaceCache[1644];
		addSprite(15101, 0, "Equipment/bl");
		addSprite(15102, 1, "Equipment/bl");
		addSprite(15109, 2, "Equipment/bl");
		removeSomething(15103);	removeSomething(15104);
		Interface.children[23] = 15101;	Interface.childX[23] = 40;			Interface.childY[23] = 205;
		Interface.children[24] = 15102;	Interface.childX[24] = 110;			Interface.childY[24] = 205;
		Interface.children[25] = 15109;	Interface.childX[25] = 39;			Interface.childY[25] = 240;
		Interface.children[26] = 27650; Interface.childX[26] = 0;			Interface.childY[26] = 0;
		Interface = addInterface(27650);
			addButton(27651, 6, "Equipment/BOX", "Experience Lock", 27659, 1, 26, 33);
			addButton(27653, 1, "Equipment/BOX", "Show Equipment Stats", 27655, 1, 40, 39);
			addButton(27654, 2, "Equipment/BOX", "Items Kept on Death", 27657, 1, 40, 39);
			setChildren(3, Interface);
			setBounds(27651, 84, 215, 0, Interface);
			setBounds(27653, 29, 205, 1, Interface);
			setBounds(27654, 124, 205, 2, Interface);
	}
		public static void EquipmentLayers(TextDrawingArea[] TDA) {
		RSInterface Interface = addInterface(16000);
		int frame = 0;
		setChildren(24, Interface);
			setBounds(1645, 83+315, 106, frame, Interface); frame++;
			setBounds(1646, 83+315, 135, frame, Interface); frame++;
			setBounds(1647, 83+315, 172, frame, Interface); frame++;
			setBounds(1648, 83+315, 213, frame, Interface); frame++;
			setBounds(1649, 27+315, 185, frame, Interface); frame++;
			setBounds(1650, 27+315, 221, frame, Interface); frame++;
			setBounds(1651, 139+315, 185, frame, Interface); frame++;
			setBounds(1652, 139+315, 221, frame, Interface); frame++;
			setBounds(1653, 53+315, 148, frame, Interface); frame++;
			setBounds(1654, 112+315, 148, frame, Interface); frame++;
			setBounds(1655, 63+315, 109, frame, Interface); frame++;
			setBounds(1656, 117+315, 108, frame, Interface); frame++;
			setBounds(1657, 83+315, 71, frame, Interface); frame++;
			setBounds(1658, 42+315, 110, frame, Interface); frame++;
			setBounds(1659, 83+315, 110, frame, Interface); frame++;
			setBounds(1660, 124+315, 110, frame, Interface); frame++;
			setBounds(1661, 27+315, 149, frame, Interface); frame++;
			setBounds(1662, 83+315, 149, frame, Interface); frame++;
			setBounds(1663, 139+315, 149, frame, Interface); frame++;
			setBounds(1664, 83+315, 189, frame, Interface); frame++;
			setBounds(1665, 83+315, 229, frame, Interface); frame++;
			setBounds(1666, 27+315, 229, frame, Interface); frame++;
			setBounds(1667, 139+315, 229, frame, Interface); frame++;
			setBounds(1688, 29+315, 111, frame, Interface); frame++;
		Interface = addInterface(16100);
		frame = 0;
		addText(19154, "", 0xFF981F, true, true, 52, TDA, 2);
		addText(1673, "Attack Bonuses", 0xFF981F, false, true, 52, TDA, 2);
		addText(1674, "Defence Bonuses", 0xFF981F, false, true, 52, TDA, 2);
		addText(1685, "Other Bonuses", 0xFF981F, false, true, 52, TDA, 2);	
		addText(1675, "Stab:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1676, "Slash:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1677, "Crush:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1678, "Magic:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1679, "Ranged:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1680, "Stab:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1681, "Slash:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1682, "Crush:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1683, "Magic:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1684, "Ranged:", 0xFF981F, false, true, 52, TDA, 1);
		addText(19157, "Summoning:", 0xFF981F, false, true, 52, TDA, 1);
		addText(19158, "Absorb Melee:", 0xFF981F, false, true, 52, TDA, 1);
		addText(19159, "Absorb Magic:", 0xFF981F, false, true, 52, TDA, 1);
		addText(19160, "Absorb Ranged:", 0xFF981F, false, true, 52, TDA, 1);
		
		addText(1686, "Strength:", 0xFF981F, false, true, 52, TDA, 1);
		addText(1687, "Prayer:", 0xFF981F, false, true, 52, TDA, 1);
		addText(19156, "Ranged Strength:", 0xFF981F, false, true, 52, TDA, 1);
		addText(19161, "Magic Damage:", 0xFF981F, false, true, 52, TDA, 1);
		
		addText(19155, "", 0xFF981F, false, true, 52, TDA, 1);
		addText(19162, "0 kg", 0xFF981F, false, true, 52, TDA, 1);
		addSprite(19163, 3, "Interfaces/Equipment/Equip");
		setChildren(22, Interface);
		int off = 13;
			setBounds(1673, 23, 71-25+(frame*off), frame, Interface); frame++;
			setBounds(1675, 28, 71-25+(frame*off), frame, Interface); frame++;
			setBounds(1676, 28, 71-25+(frame*off), frame, Interface); frame++;
			setBounds(1677, 28, 71-25+(frame*off), frame, Interface); frame++; 
			setBounds(1678, 28, 71-25+(frame*off), frame, Interface); frame++;
			setBounds(1679, 28, 71-25+(frame*off), frame, Interface); frame++;
			setBounds(1674, 23, 71-25+(frame*off), frame, Interface); frame++;
			setBounds(1680, 28, 71-25+(frame*off), frame, Interface); frame++;
			setBounds(1681, 28, 71-25+(frame*off), frame, Interface); frame++;
			setBounds(1682, 28, 71-25+(frame*off), frame, Interface); frame++;
			setBounds(1683, 28, 71-25+(frame*off), frame, Interface); frame++;
			setBounds(1684, 28, 71-25+(frame*off), frame, Interface); frame++;

			setBounds(19157, 28, 71-25+(frame*off), frame, Interface); frame++;
			setBounds(19158, 28, 71-25+(frame*off), frame, Interface); frame++; 
			setBounds(19159, 28, 71-25+(frame*off), frame, Interface); frame++;
			setBounds(19160, 28, 71-25+(frame*off), frame, Interface); frame++;
			
			setBounds(1685, 23, 71-25+(frame*off), frame, Interface); frame++;
			
			setBounds(1686, 28, 71-25+(frame*off), frame, Interface); frame++;
			setBounds(19156, 28, 71-25+(frame*off), frame, Interface); frame++;
			setBounds(1687, 28, 71-25+(frame*off), frame, Interface); frame++;
			setBounds(19161, 28, 71-25+(frame*off), frame, Interface); frame++;
			setBounds(19162, 408, 288, frame, Interface); frame++;
			//setBounds(19163, 387, 287, frame, Interface); frame++;
	}
	
	public static void equipmentScreen2(TextDrawingArea[] TDA) {
		RSInterface Interface = addInterface(19148);
		addSprite(19149, 0, "Interfaces/Equipment/Equip");
		//addHover(19150, 1, 0, 19151, 1, "Interfaces/Equipment/Equip", 21, 21, "Close");
		//addHovered(19151, 2, "Interfaces/Equipment/Equip", 21, 21, 19152);
		addHover(17102, 3, 0, 10601, 1, "Interfaces/Equipment/SPRITE", 17, 17, "Close Window");
		addHovered(10601, 3, "Interfaces/Equipment/SPRITE", 17, 17, 10602);
		addChar(19153);
		int last = 8;
		int frame = 0;
		setChildren(last, Interface);
		setBounds(19149, 12, 5, frame, Interface);frame++;
		setBounds(10601, 474, 8, frame, Interface);frame++;
		setBounds(17102, 474, 8, frame, Interface);frame++;
		setBounds(19153, 193, 210, frame, Interface);frame++;
		setBounds(19154, 251, 29, frame, Interface);frame++;
		setBounds(16000, 0, -10, frame, Interface); frame++;
		setBounds(16100, 0, -13, frame, Interface); frame++;
		setBounds(19155, 94, 286, frame, Interface); frame++;
	}
		
		public static void addChar(int ID) { 
			RSInterface t = interfaceCache[ID] = new RSInterface(); 
			t.id = ID; 
			t.parentID = ID; 
			t.type = 6;
			t.atActionType = 0; 
			t.contentType = 328; 
			t.width = 180; 
			t.height = 190; 
			t.aByte254 = 0;
			t.mOverInterToTrigger = 0;
			t.modelZoom = 560;
			t.modelRotation1 = 30;
			t.modelRotation2 = 0; 
			t.anInt257 = -1; 
			t.anInt258 = -1; 
		}
		
		private static Sprite LoadLunarSprite(int i, String s) {
			Sprite sprite = imageLoader(i,"/Lunar/" + s);
			return sprite;
		}
		
		public static void addLunarSprite(int i, int j, String name) {
        RSInterface RSInterface = addInterface(i);
        RSInterface.id = i;
        RSInterface.parentID = i;
        RSInterface.type = 5;
        RSInterface.atActionType = 5;
        RSInterface.contentType = 0;
        RSInterface.aByte254 = 0;
        RSInterface.mOverInterToTrigger = 52;
        RSInterface.sprite1 = LoadLunarSprite(j, name);
        RSInterface.width = 500;
        RSInterface.height = 500;
        RSInterface.tooltip = "";
    }
	public static void drawRune(int i,int id, String runeName) {
        RSInterface RSInterface = addInterface(i);
        RSInterface.type = 5;
        RSInterface.atActionType = 0;
        RSInterface.contentType = 0;
        RSInterface.aByte254 = 0;
        RSInterface.mOverInterToTrigger = 52;
        RSInterface.sprite1 = LoadLunarSprite(id, "RUNE");
        RSInterface.width = 500;
        RSInterface.height = 500;
    }
	public static void addRuneText(int ID, int runeAmount, int RuneID, TextDrawingArea[] font){
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 4;
		rsInterface.atActionType = 0;
		rsInterface.contentType = 0;
		rsInterface.width = 0;
		rsInterface.height = 14;
		rsInterface.aByte254 = 0;
		rsInterface.mOverInterToTrigger= -1;
		rsInterface.anIntArray245 = new int[1];
		rsInterface.anIntArray212 = new int[1];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = runeAmount;
		rsInterface.valueIndexArray = new int[1][4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = RuneID;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.centerText = true;
		rsInterface.textDrawingAreas = font[0];
		//rsInterface.textShadowed = true;
		rsInterface.message = "%1/"+runeAmount+"";
		rsInterface.popupString = "";
		//rsInterface.disabledColour = 12582912;
		//rsInterface.enabledColour = 49152;	
	}
	public static void homeTeleport(){
		RSInterface RSInterface = addInterface(30000);
		RSInterface.tooltip = "Cast @gre@Lunar Home Teleport";
		RSInterface.id = 30000;
        RSInterface.parentID = 30000;
        RSInterface.type = 5;
        RSInterface.atActionType = 5;
        RSInterface.contentType = 0;
        RSInterface.aByte254 = 0;
        RSInterface.mOverInterToTrigger = 30001;
        RSInterface.sprite1 = LoadLunarSprite(1, "SPRITE");
        RSInterface.width = 20;
        RSInterface.height = 20;
		RSInterface Int = addInterface(30001);
		Int.isMouseoverTriggered = true;
		Int.totalChildren(1);
		addLunarSprite(30002, 0, "SPRITE");
		setBounds(30002, 0, 0,0, Int);
	}
	public static void addLunar2RunesSmallBox(int ID, int r1, int r2, int ra1, int ra2,int rune1, int lvl,String name, String descr,TextDrawingArea[] TDA,int sid,int suo,int type){
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID+1;
		//rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast On";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@"+name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[3];
		rsInterface.anIntArray212 = new int[3];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = lvl;
		rsInterface.valueIndexArray = new int[3][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[3];
		rsInterface.valueIndexArray[2][0] = 1;
		rsInterface.valueIndexArray[2][1] = 6;
		rsInterface.valueIndexArray[2][2] = 0;
		rsInterface.sprite2 = LoadLunarSprite(sid, "LUNARON");
		rsInterface.sprite1 = LoadLunarSprite(sid, "LUNAROFF");
		RSInterface INT = addInterface(ID+1);
		INT.isMouseoverTriggered = true;
		INT.totalChildren(7);
		addLunarSprite(ID+2, 0, "BOX");
		setBounds(ID+2, 0, 0, 0, INT);
		addText(ID+3, "Level "+(lvl+1)+": "+name, 0xFF981F, true, true, 52, TDA, 1);
		setBounds(ID+3, 90, 4, 1, INT);
		addText(ID+4, descr, 0xAF6A1A, true, true, 52, TDA, 0);	
		setBounds(ID+4, 90, 19, 2, INT);
		setBounds(30016, 37, 35, 3, INT);//Rune
		setBounds(rune1, 112, 35, 4, INT);//Rune
		addRuneText(ID+5, ra1+1, r1, TDA);
		setBounds(ID+5, 50, 66, 5, INT);
		addRuneText(ID+6, ra2+1, r2, TDA);
		setBounds(ID+6, 123, 66, 6, INT);

	}
	public static void addLunar3RunesSmallBox(int ID, int r1, int r2, int r3, int ra1, int ra2, int ra3,int rune1, int rune2, int lvl,String name, String descr,TextDrawingArea[] TDA, int sid,int suo,int type){
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID+1;
		//rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@"+name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[4];
		rsInterface.anIntArray212 = new int[4];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = ra3;
		rsInterface.anIntArray245[3] = 3;
		rsInterface.anIntArray212[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite2 = LoadLunarSprite(sid, "LUNARON");
		rsInterface.sprite1 = LoadLunarSprite(sid, "LUNAROFF");
		RSInterface INT = addInterface(ID+1);
		INT.isMouseoverTriggered = true;
		INT.totalChildren(9);
		addLunarSprite(ID+2, 0, "BOX");
		setBounds(ID+2, 0, 0, 0, INT);
		addText(ID+3, "Level "+(lvl+1)+": "+name, 0xFF981F, true, true, 52, TDA, 1);setBounds(ID+3, 90, 4, 1, INT);
		addText(ID+4, descr, 0xAF6A1A, true, true, 52, TDA, 0);	setBounds(ID+4, 90, 19, 2, INT);
		setBounds(30016, 14, 35, 3, INT);
		setBounds(rune1, 74, 35, 4, INT);
		setBounds(rune2, 130, 35, 5, INT);
		addRuneText(ID+5, ra1+1, r1, TDA);
		setBounds(ID+5, 26, 66, 6, INT);
		addRuneText(ID+6, ra2+1, r2, TDA);
		setBounds(ID+6, 87, 66, 7, INT);
		addRuneText(ID+7, ra3+1, r3, TDA);
		setBounds(ID+7, 142, 66, 8, INT);
	}
	public static void addLunar3RunesBigBox(int ID, int r1, int r2, int r3, int ra1, int ra2, int ra3,int rune1, int rune2, int lvl,String name, String descr,TextDrawingArea[] TDA, int sid,int suo,int type){
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID+1;
		//rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@"+name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[4];
		rsInterface.anIntArray212 = new int[4];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = ra3;
		rsInterface.anIntArray245[3] = 3;
		rsInterface.anIntArray212[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite2 = LoadLunarSprite(sid, "LUNARON");
		rsInterface.sprite1 = LoadLunarSprite(sid, "LUNAROFF");
		RSInterface INT = addInterface(ID+1);
		INT.isMouseoverTriggered = true;
		INT.totalChildren(9);
		addLunarSprite(ID+2, 1, "BOX");
		setBounds(ID+2, 0, 0, 0, INT);
		addText(ID+3, "Level "+(lvl+1)+": "+name, 0xFF981F, true, true, 52, TDA, 1);setBounds(ID+3, 90, 4, 1, INT);
		addText(ID+4, descr, 0xAF6A1A, true, true, 52, TDA, 0);	setBounds(ID+4, 90, 21, 2, INT);
		setBounds(30016, 14, 48, 3, INT);
		setBounds(rune1, 74, 48, 4, INT);
		setBounds(rune2, 130, 48, 5, INT);
		addRuneText(ID+5, ra1+1, r1, TDA);
		setBounds(ID+5, 26, 79, 6, INT);
		addRuneText(ID+6, ra2+1, r2, TDA);
		setBounds(ID+6, 87, 79, 7, INT);
		addRuneText(ID+7, ra3+1, r3, TDA);
		setBounds(ID+7, 142, 79, 8, INT);
	}
	public static void addLunar3RunesLargeBox(int ID, int r1, int r2, int r3, int ra1, int ra2, int ra3,int rune1, int rune2, int lvl,String name, String descr,TextDrawingArea[] TDA, int sid,int suo,int type){
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID+1;
		//rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@"+name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[4];
		rsInterface.anIntArray212 = new int[4];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = ra3;
		rsInterface.anIntArray245[3] = 3;
		rsInterface.anIntArray212[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite2 = LoadLunarSprite(sid, "LUNARON");
		rsInterface.sprite1 = LoadLunarSprite(sid, "LUNAROFF");
		RSInterface INT = addInterface(ID+1);
		INT.isMouseoverTriggered = true;
		INT.totalChildren(9);
		addLunarSprite(ID+2, 2, "BOX");
		setBounds(ID+2, 0, 0, 0, INT);
		addText(ID+3, "Level "+(lvl+1)+": "+name, 0xFF981F, true, true, 52, TDA, 1);
		setBounds(ID+3, 90, 4, 1, INT);
		addText(ID+4, descr, 0xAF6A1A, true, true, 52, TDA, 0);	
		setBounds(ID+4, 90, 34, 2, INT);
		setBounds(30016, 14, 61, 3, INT);
		setBounds(rune1, 74, 61, 4, INT);
		setBounds(rune2, 130, 61, 5, INT);
		addRuneText(ID+5, ra1+1, r1, TDA);
		setBounds(ID+5, 26, 92, 6, INT);
		addRuneText(ID+6, ra2+1, r2, TDA);
		setBounds(ID+6, 87, 92, 7, INT);
		addRuneText(ID+7, ra3+1, r3, TDA);
		setBounds(ID+7, 142, 92, 8, INT);
	}
	public static void configureLunar(TextDrawingArea[] TDA){
		homeTeleport();
		drawRune(30003,1, "Fire");
		drawRune(30004,2, "Water");
		drawRune(30005,3, "Air");
		drawRune(30006,4, "Earth");
		drawRune(30007,5, "Mind");
		drawRune(30008,6, "Body");
		drawRune(30009,7, "Death");
		drawRune(30010,8, "Nature");
		drawRune(30011,9, "Chaos");
		drawRune(30012,10, "Law");
		drawRune(30013,11, "Cosmic");
		drawRune(30014,12, "Blood");
		drawRune(30015,13, "Soul");
		drawRune(30016,14, "Astral");
		addLunar3RunesSmallBox(30017, 9075, 554, 555, 0, 4, 3, 30003, 30004, 64, "Bake Pie","Bake pies without a stove",TDA,0, 16,2);
		addLunar2RunesSmallBox(30025, 9075, 557, 0, 7, 30006, 65,"Cure Plant", "Cure disease on farming patch",TDA,1, 4,2);
		addLunar3RunesBigBox(30032, 9075, 564, 558, 0,0, 0, 30013, 30007, 65,"Monster Examine", "Detect the combat statistics of a\\nmonster",TDA, 2,2,2);
		addLunar3RunesSmallBox(30040, 9075, 564, 556, 0, 0, 1, 30013, 30005, 66, "NPC Contact","Speak with varied NPCs",TDA,3,0,2);
		addLunar3RunesSmallBox(30048, 9075, 563, 557, 0, 0, 9, 30012, 30006, 67, "Cure Other","Cure poisoned players",TDA,4,8,2);
		addLunar3RunesSmallBox(30056, 9075, 555, 554, 0, 2, 0, 30004, 30003, 67, "Humidify","fills certain vessels with water",TDA,5,0,5);
		addLunar3RunesSmallBox(30064, 9075, 563, 557, 1, 0, 1, 30012, 30006, 68, "Moonclan Teleport","Teleports you to moonclan island",TDA,6,0,5);
		addLunar3RunesBigBox(30075, 9075, 563, 557, 1, 0, 3, 30012,  30006, 69,"Tele Group Moonclan", "Teleports players to Moonclan\\nisland",TDA, 7,0,5);
		addLunar3RunesSmallBox(30083, 9075, 563, 557, 1, 0, 5, 30012, 30006, 70, "Ourania Teleport","Teleports you to ourania rune altar",TDA,8,0,5);
		addLunar3RunesSmallBox(30091, 9075, 564, 563, 1, 1, 0, 30013, 30012, 70, "Cure Me","Cures Poison",TDA,9,0,5);
		addLunar2RunesSmallBox(30099, 9075, 557, 1, 1, 30006, 70,"Hunter Kit", "Get a kit of hunting gear",TDA,10,0,5);
		addLunar3RunesSmallBox(30106, 9075, 563, 555,  1, 0,0, 30012, 30004, 71,"Waterbirth Teleport", "Teleports you to Waterbirth island",TDA,11,0,5);
		addLunar3RunesBigBox(30114, 9075, 563, 555, 1, 0, 4, 30012, 30004, 72,"Tele Group Waterbirth", "Teleports players to Waterbirth\\nisland",TDA, 12,0,5);
		addLunar3RunesSmallBox(30122, 9075, 564, 563, 1, 1, 1, 30013, 30012, 73, "Cure Group","Cures Poison on players",TDA,13,0,5);
		addLunar3RunesBigBox(30130, 9075, 564, 559, 1, 1, 4, 30013, 30008, 74,"Stat Spy", "Cast on another player to see their\\nskill levels",TDA, 14,8,2);
		addLunar3RunesBigBox(30138, 9075, 563, 554, 1, 1, 2, 30012, 30003, 74,"Barbarian Teleport", "Teleports you to the Barbarian\\noutpost",TDA, 15,0,5);
		addLunar3RunesBigBox(30146, 9075, 563, 554, 1, 1, 5, 30012, 30003, 75,"Tele Group Barbarian", "Teleports players to the Barbarian\\noutpost",TDA, 16,0,5);
		addLunar3RunesSmallBox(30154, 9075, 554, 556, 1, 5, 9, 30003, 30005, 76, "Superglass Make","Make glass without a furnace",TDA,17, 16,2);
		addLunar3RunesSmallBox(30162, 9075, 563, 555, 1, 1, 3, 30012, 30004, 77, "Khazard Teleport","Teleports you to Port khazard",TDA,18,0,5);
		addLunar3RunesSmallBox(30170, 9075, 563, 555, 1, 1, 7, 30012, 30004, 78, "Tele Group Khazard","Teleports players to Port khazard",TDA,19,0,5);
		addLunar3RunesBigBox(30178, 9075, 564, 559, 1, 0, 4, 30013, 30008, 78,"Dream", "Take a rest and restore hitpoints 3\\n times faster",TDA, 20,0,5);
		addLunar3RunesSmallBox(30186, 9075, 557, 555, 1, 9, 4, 30006, 30004, 79, "String Jewellery","String amulets without wool",TDA,21,0,5);
		addLunar3RunesLargeBox(30194, 9075, 557, 555, 1, 9, 9, 30006, 30004, 80,"Stat Restore Pot\\nShare", "Share a potion with up to 4 nearby\\nplayers",TDA, 22,0,5);
		addLunar3RunesSmallBox(30202, 9075, 554, 555, 1, 6, 6, 30003, 30004, 81, "Magic Imbue","Combine runes without a talisman",TDA,23,0,5);
		addLunar3RunesBigBox(30210, 9075, 561, 557, 2, 1, 14, 30010, 30006, 82,"Fertile Soil", "Fertilise a farming patch with super\\ncompost",TDA, 24, 4,2);
		addLunar3RunesBigBox(30218, 9075, 557, 555, 2, 11, 9, 30006, 30004, 83,"Boost Potion Share", "Shares a potion with up to 4 nearby\\nplayers",TDA, 25, 0,5);
		addLunar3RunesSmallBox(30226, 9075, 563, 555, 2, 2, 9, 30012, 30004, 84, "Fishing Guild Teleport","Teleports you to the fishing guild",TDA,26,0,5);
		addLunar3RunesLargeBox(30234, 9075, 563, 555, 1, 2, 13, 30012, 30004, 85, "Tele Group Fishing\\nGuild", "Teleports players to the Fishing\\nGuild",TDA, 27,0,5);
		addLunar3RunesSmallBox(30242, 9075, 557, 561, 2, 14, 0, 30006, 30010, 85, "Plank Make","Turn Logs into planks",TDA,28,16,5);
		/********Cut Off Limit**********/
		addLunar3RunesSmallBox(30250, 9075, 563, 555, 2, 2, 9, 30012, 30004, 86, "Catherby Teleport","Teleports you to Catherby",TDA,29,0,5);
		addLunar3RunesSmallBox(30258, 9075, 563, 555, 2, 2, 14, 30012, 30004, 87, "Tele Group Catherby","Teleports players to Catherby",TDA,30,0,5);
		addLunar3RunesSmallBox(30266, 9075, 563, 555, 2, 2, 7, 30012, 30004, 88, "Ice Plateau Teleport","Teleports you to Ice Plateau",TDA,31,0,5);
		addLunar3RunesBigBox(30274, 9075, 563, 555, 2, 2, 15, 30012, 30004, 89, "Tele Group Ice\\n Plateau","Teleports players to Ice Plateau",TDA,32,0,5);
		addLunar3RunesBigBox(30282, 9075, 563, 561, 2, 1, 0, 30012, 30010, 90, "Energy Transfer","Spend hitpoints and SA Energy to\\n give another player hitpoints and run energy",TDA,33,8,2);
		addLunar3RunesBigBox(30290, 9075, 563, 565, 2, 2, 0, 30012, 30014, 91, "Heal Other","Transfer up to 75% of hitpoints\\n to another player",TDA,34,8,2);
		addLunar3RunesBigBox(30298, 9075, 560, 557, 2, 1, 9, 30009, 30006, 92, "Vengeance Other","Allows another player to rebound\\ndamage to an opponent",TDA,35,8,2);
		addLunar3RunesSmallBox(30306, 9075, 560, 557, 3, 1, 9,30009, 30006, 93, "Vengeance","Rebound damage to an opponent",TDA,36,0,5);
		addLunar3RunesBigBox(30314, 9075, 565, 563, 3, 2, 5, 30014, 30012, 94, "Heal Group","Transfer up to 75% of hitpoints to a group",TDA,37,0,5);
		addLunar3RunesBigBox(30322, 9075, 564, 563, 2, 1, 0, 30013, 30012, 95, "Spellbook Swap","Change to another spellbook for 1\\nspell cast",TDA,38,0,5);
	}
	public static void constructLunar(){
		RSInterface Interface = addInterface(29999);
		Interface.totalChildren(80);
		setBounds(30000, 11, 10, 0, Interface);
		setBounds(30017, 40, 9, 1, Interface);
		setBounds(30025, 71, 12, 2, Interface);
		setBounds(30032, 103, 10, 3, Interface);
		setBounds(30040, 135, 12, 4, Interface);
		setBounds(30048, 165, 10, 5, Interface);
		setBounds(30056, 8, 38, 6, Interface);
		setBounds(30064, 39, 39, 7, Interface);
		setBounds(30075, 71, 39, 8, Interface);
		setBounds(30083, 103, 39, 9, Interface);
		setBounds(30091, 135, 39, 10, Interface);
		setBounds(30099, 165, 37, 11, Interface);
		setBounds(30106, 12, 68, 12, Interface);
		setBounds(30114, 42, 68, 13, Interface);
		setBounds(30122, 71, 68, 14, Interface);
		setBounds(30130, 103, 68, 15, Interface);
		setBounds(30138, 135, 68, 16, Interface);
		setBounds(30146, 165, 68, 17, Interface);
		setBounds(30154, 14, 97, 18, Interface);
		setBounds(30162, 42, 97, 19, Interface);
		setBounds(30170, 71, 97, 20, Interface);
		setBounds(30178, 101, 97, 21, Interface);
		setBounds(30186, 135, 98, 22, Interface);
		setBounds(30194, 168, 98, 23, Interface);
		setBounds(30202, 11, 125, 24, Interface);
		setBounds(30210, 42, 124, 25, Interface);
		setBounds(30218, 74, 125, 26, Interface);
		setBounds(30226, 103, 125, 27, Interface);
		setBounds(30234, 135, 125, 28, Interface);
		setBounds(30242, 164, 126, 29, Interface);
		setBounds(30250, 10, 155, 30, Interface);	
		setBounds(30258, 42, 155, 31, Interface);	
		setBounds(30266, 71, 155, 32, Interface);	
		setBounds(30274, 103, 155, 33, Interface);
		setBounds(30282, 136, 155, 34, Interface);	
		setBounds(30290, 165, 155, 35, Interface);	
		setBounds(30298, 13, 185, 36, Interface);	
		setBounds(30306, 42, 185, 37, Interface);	
		setBounds(30314, 71, 184, 38, Interface);
		setBounds(30322, 104, 184, 39, Interface);	
		setBounds(30001, 6, 184, 40, Interface);//hover
		setBounds(30018, 5, 176, 41, Interface);//hover
		setBounds(30026, 5, 176, 42, Interface);//hover
		setBounds(30033, 5, 163, 43, Interface);//hover
		setBounds(30041, 5, 176, 44, Interface);//hover
		setBounds(30049, 5, 176, 45, Interface);//hover
		setBounds(30057, 5, 176, 46, Interface);//hover
		setBounds(30065, 5, 176, 47, Interface);//hover
		setBounds(30076, 5, 163, 48, Interface);//hover
		setBounds(30084, 5, 176, 49, Interface);//hover
		setBounds(30092, 5, 176, 50, Interface);//hover
		setBounds(30100, 5, 176, 51, Interface);//hover
		setBounds(30107, 5, 176, 52, Interface);//hover
		setBounds(30115, 5, 163, 53, Interface);//hover
		setBounds(30123, 5, 176, 54, Interface);//hover
		setBounds(30131, 5, 163, 55, Interface);//hover
		setBounds(30139, 5, 163, 56, Interface);//hover
		setBounds(30147, 5, 163, 57, Interface);//hover
		setBounds(30155, 5, 176, 58, Interface);//hover
		setBounds(30163, 5, 176, 59, Interface);//hover
		setBounds(30171, 5, 176, 60, Interface);//hover
		setBounds(30179, 5, 163, 61, Interface);//hover
		setBounds(30187, 5, 176, 62, Interface);//hover
		setBounds(30195, 5, 149, 63, Interface);//hover
		setBounds(30203, 5, 176, 64, Interface);//hover
		setBounds(30211, 5, 163, 65, Interface);//hover
		setBounds(30219, 5, 163, 66, Interface);//hover
		setBounds(30227, 5, 176, 67, Interface);//hover
		setBounds(30235, 5, 149, 68, Interface);//hover
		setBounds(30243, 5, 176, 69, Interface);//hover
		setBounds(30251, 5, 5, 70, Interface);//hover
		setBounds(30259, 5, 5, 71, Interface);//hover
		setBounds(30267, 5, 5, 72, Interface);//hover
		setBounds(30275, 5, 5, 73, Interface);//hover	
		setBounds(30283, 5, 5, 74, Interface);//hover
		setBounds(30291, 5, 5, 75, Interface);//hover
		setBounds(30299, 5, 5, 76, Interface);//hover
		setBounds(30307, 5, 5, 77, Interface);//hover
		setBounds(30323, 5, 5, 78, Interface);//hover
		setBounds(30315, 5, 5, 79, Interface);//hover
	}
		
		public static void addButton(int i, int j, String name, int W, int H, String S, int AT) {
			RSInterface RSInterface = addInterface(i);
			RSInterface.id = i;
			RSInterface.parentID = i;
			RSInterface.type = 5;
			RSInterface.atActionType = AT;
			RSInterface.contentType = 0;
			RSInterface.aByte254 = 0;
			RSInterface.mOverInterToTrigger = 52;
			RSInterface.sprite1 = imageLoader(j,name);
			RSInterface.sprite2 = imageLoader(j,name);
			RSInterface.width = W;
			RSInterface.height = H;
			RSInterface.tooltip = S;
		}


	
	
}
