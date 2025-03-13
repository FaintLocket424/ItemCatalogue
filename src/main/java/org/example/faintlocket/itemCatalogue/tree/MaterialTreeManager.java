package org.example.faintlocket.itemCatalogue.tree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class MaterialTreeManager implements Iterable<MaterialTree> {
    private final Set<MaterialTree> trees = new HashSet<>();

    public MaterialTreeManager() {
        MaterialTree tree1 = new MaterialTree();
        tree1.getRoot()
            .addChild(MaterialTree.BREWING_CATEGORY())
        ;
        this.trees.add(tree1);

        MaterialTree tree2 = new MaterialTree();
        tree2.getRoot()
            .addChild(MaterialTree.MATERIALS_CATEGORY())
        ;
        this.trees.add(tree2);
    }

    public Set<MaterialTree> getTrees() {
        return trees;
    }

    @Override
    public @NotNull Iterator<MaterialTree> iterator() {
        return trees.iterator();
    }
}
