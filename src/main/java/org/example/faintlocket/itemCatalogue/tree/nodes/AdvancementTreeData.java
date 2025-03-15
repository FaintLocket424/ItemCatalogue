package org.example.faintlocket.itemCatalogue.tree.nodes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import org.example.faintlocket.itemCatalogue.DatapackGenerator;
import org.example.faintlocket.itemCatalogue.tree.TreeNode;
import org.jetbrains.annotations.NotNull;

public abstract class AdvancementTreeData {

    private final String BACKGROUND_TEXTURE = "minecraft:textures/block/black_concrete.png";

    protected abstract JsonElement getDescription();

    protected abstract JsonElement getTitle();

    protected abstract String getIconKey();

    protected abstract String getAdvancementKey();

    protected abstract String getFrameProperty();

    protected abstract JsonObject getCriterionObject();

    protected boolean isRoot() {
        return false;
    }

    protected JsonObject getIcon() {
        // Set the id of the icon of the advancement.
        JsonObject icon = new JsonObject();
        icon.addProperty("id", getIconKey());
        return icon;
    }

    private JsonObject getCriteriaObject() {
        JsonObject criteria = new JsonObject();

        /*
        {
            get_item: {
                "trigger": "minecraft:inventory_changed"
                "conditions": {
                    "items": [
                        {
                            "items": [
                                "minecraft:oak_planks"
                            ]
                        }
                    ]
                }
            }
        }
         */

        criteria.add("criterion", getCriterionObject());

        return criteria;
    }

    private JsonObject getDisplayObject() {
        // The root object of the display section.
        JsonObject display = new JsonObject();

        display.add("icon", getIcon());

        // Set the title of the advancement.
        display.add("title", getTitle());

        // Set the description of the advancement.
        display.add("description", getDescription());

        display.addProperty("frame", getFrameProperty());
        display.addProperty("show_toast", false);
        display.addProperty("announce_to_chat", false);
        display.addProperty("hidden", false);

        if (isRoot()) {
            display.addProperty("background", BACKGROUND_TEXTURE);
        }

        return display;
    }

    public void writeAdvancementJSON(
        File advancementFolder,
        String treeSubfolder,
        TreeNode<AdvancementTreeData> parent
    ) throws IOException {
        // Create root object
        JsonObject root = new JsonObject();

        // Set the "parent" tag to the NamespaceKey of the parent advancement.
        if (!isRoot()) {
            root.addProperty("parent",
                "%s:%s/%s".formatted(
                    DatapackGenerator.datapackNamespace,
                    treeSubfolder,
                    parent.getValue().getAdvancementKey()
                )
            );
        }

        JsonObject display = getDisplayObject();
        JsonObject criteria = getCriteriaObject();
        root.add("display", display);
        root.add("criteria", criteria);

        String fileName = "%s.json".formatted(getAdvancementKey());
        DatapackGenerator.WriteJSONFile(root, advancementFolder, fileName);
    }
}
