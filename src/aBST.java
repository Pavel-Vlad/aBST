import java.util.*;

class aBST {
    public Integer[] Tree; // массив ключей

    public aBST(int depth) {
        // правильно рассчитайте размер массива для дерева глубины depth:
        int tree_size = (int) (Math.pow(2, (depth + 1))) - 1;
        Tree = new Integer[tree_size];
        for (int i = 0; i < tree_size; i++) Tree[i] = null;
    }

    public Integer FindKeyIndex(int key) {
        // ищем в массиве индекс ключа
        int indexKey = 0;
        if (Tree[indexKey] == null) { // если массив пустой
            return 0;
        }
        while (Tree[indexKey] != null) {
            if (key < Tree[indexKey]) {
                indexKey = 2 * indexKey + 1;
            }
            else if (key > Tree[indexKey]) {
                indexKey = 2 * indexKey + 2;
            }
            else if (key == Tree[indexKey]) {
                break;
            }
            if (indexKey >= Tree.length) return null; // не найден
            if (Tree[indexKey] == null) return - indexKey;
        }
        return indexKey;
    }

    public int AddKey(int key) {
        // добавляем ключ в массив
        int indexKey = 0;
        if (Tree[indexKey] == null) { // если массив пустой
            Tree[indexKey] = key;
            return indexKey;
        }
        while (Tree[indexKey] != null) {
            if (key < Tree[indexKey]) {
                indexKey = 2 * indexKey + 1;
            }
            else if (key > Tree[indexKey]) {
                indexKey = 2 * indexKey + 2;
            }
            else if (key == Tree[indexKey]) {
                return indexKey;
            }
            if (indexKey >= Tree.length) return -1;
        }
        Tree[indexKey] = key;
        return indexKey;
        // индекс добавленного/существующего ключа или -1 если не удалось
    }

}