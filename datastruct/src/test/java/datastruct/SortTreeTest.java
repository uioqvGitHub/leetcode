package datastruct;

import com.uioqv.datastruct.tree.AbstractTree;
import com.uioqv.datastruct.tree.sort.SortTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author LiuGuoQing
 * @since 2020-04-09
 */
public class SortTreeTest {
    Random random = new Random();

    @Test
    public void testInsert() {
        testLoopDubleEqualse(this::testBeforeLoop);
    }

    @Test
    public void testLoop() {
        testLoopDubleEqualse((tree) -> testLoop(tree, AbstractTree::beforeLoop));
        testLoopDubleEqualse((tree) -> testLoop(tree, AbstractTree::afterLoop));
        testLoopDubleEqualse((tree) -> testLoop(tree, AbstractTree::centerLoop));
    }

    private <T extends Comparable<T>> List<T> testBeforeLoop(AbstractTree<T> tree) {
        return testLoop(tree, AbstractTree::beforeLoop);
    }



    private <T extends Comparable<T>> List<T> testLoop(
            AbstractTree<T> tree,
            BiConsumer<AbstractTree<T>, Consumer<T>> loopMethod) {
        List<T> list2 = new ArrayList<>();
        loopMethod.accept(tree, list2::add);
        System.out.println(list2);
        return list2;
    }


    private void testLoopDubleEqualse(Function<SortTree<Integer>, List<Integer>> testLoopMethod) {
        SortTree<Integer> integerSortTree = testRandInsert();
        List<Integer> list = testLoopMethod.apply(integerSortTree);
        SortTree<Integer> sortTree2 = new SortTree<>();
        list.forEach(sortTree2::insert);
        List<Integer> list2  =  testLoopMethod.apply(sortTree2);
        System.out.println(list.equals(list2));
    }


    private SortTree<Integer> testRandInsert() {
        SortTree<Integer> sortTree = new SortTree<>();
        random.ints(100, 1, 500).forEach(sortTree::insert);

        return sortTree;
    }


}
