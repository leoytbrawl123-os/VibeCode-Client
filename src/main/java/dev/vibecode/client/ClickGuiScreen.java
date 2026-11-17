package dev.vibecode.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public final class ClickGuiScreen extends Screen {
    private static final int PANEL_WIDTH = 270;
    private static final int PANEL_HEIGHT = 174;
    private boolean showStatusHud = true;

    public ClickGuiScreen() {
        super(Text.literal("VibeCode"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);

        int left = (this.width - PANEL_WIDTH) / 2;
        int top = (this.height - PANEL_HEIGHT) / 2;

        // Main panel and header.
        context.fill(left, top, left + PANEL_WIDTH, top + PANEL_HEIGHT, 0xF0121420);
        context.fill(left, top, left + PANEL_WIDTH, top + 2, 0xFF36C5F0);
        context.fill(left, top + 27, left + PANEL_WIDTH, top + 28, 0xFF303747);

        context.drawTextWithShadow(this.textRenderer, Text.literal("VIBECODE"), left + 14, top + 11, 0xFFFFFFFF);
        context.drawTextWithShadow(this.textRenderer, Text.literal("CLIENT  /  1.21.11"), left + 14, top + 39, 0xFF8E9AAF);

        // Harmless visual setting row.
        int rowTop = top + 65;
        boolean hovered = mouseX >= left + 12 && mouseX <= left + PANEL_WIDTH - 12
                && mouseY >= rowTop && mouseY <= rowTop + 34;
        context.fill(left + 10, rowTop, left + PANEL_WIDTH - 10, rowTop + 34,
                hovered ? 0xFF293345 : 0xFF202838);
        context.drawTextWithShadow(this.textRenderer, Text.literal("Status HUD"), left + 20, rowTop + 7, 0xFFFFFFFF);
        context.drawTextWithShadow(this.textRenderer,
                Text.literal(showStatusHud ? "ON" : "OFF"),
                left + PANEL_WIDTH - 43, rowTop + 7,
                showStatusHud ? 0xFF36C5F0 : 0xFF8993A4);

        context.drawTextWithShadow(this.textRenderer,
                Text.literal("Right-click: open/close GUI"),
                left + 14, top + 125, 0xFF9AA6B8);
        context.drawTextWithShadow(this.textRenderer,
                Text.literal("Click a row to change its setting"),
                left + 14, top + 143, 0xFF68778D);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            int left = (this.width - PANEL_WIDTH) / 2;
            int top = (this.height - PANEL_HEIGHT) / 2;
            int rowTop = top + 65;
            if (mouseX >= left + 10 && mouseX <= left + PANEL_WIDTH - 10
                    && mouseY >= rowTop && mouseY <= rowTop + 34) {
                showStatusHud = !showStatusHud;
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
