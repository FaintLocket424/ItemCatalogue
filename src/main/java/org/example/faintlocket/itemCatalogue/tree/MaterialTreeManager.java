package org.example.faintlocket.itemCatalogue.tree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class MaterialTreeManager implements Iterable<MaterialTree> {

    private final Set<MaterialTree> trees = new HashSet<>();

    public MaterialTreeManager(String datapackNamespace) {
        int page_id = 0;

        MaterialTree tree1 = new MaterialTree("%s_page_%d".formatted(datapackNamespace, page_id++));
        tree1.getRoot()
            .addChild(MaterialTree.BREWING_CATEGORY())
        ;
        this.trees.add(tree1);

        MaterialTree tree2 = new MaterialTree("%s_page_%d".formatted(datapackNamespace, page_id++));
        tree2.getRoot()
            .addChild(MaterialTree.MATERIALS_CATEGORY())
        ;
        this.trees.add(tree2);
    }

    @Override
    public @NotNull Iterator<MaterialTree> iterator() {
        return trees.iterator();
    }
}
