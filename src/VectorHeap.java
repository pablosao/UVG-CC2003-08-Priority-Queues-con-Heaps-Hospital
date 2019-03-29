import java.util.Vector;


/***
 * Implementación de clase Vector Heaps
 *
 * @author Duane A. Bailey
 * @version September 2007
 *
 * @param <E> extends Comparable<E>
 */


public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>{

    protected Vector<E> DATOS;

    public VectorHeap(){
        DATOS = new Vector<E>();
    }

    public VectorHeap(Vector<E> v)
    // post: constructs a new priority queue from an unordered vector
    {
        int i;
        DATOS = new Vector<E>(v.size()); // we know ultimate size
        for (i = 0; i < v.size(); i++)
        { // add elements to heap
            add(v.get(i));
        }
    }

    protected static int parent(int i)
    // pre: 0 <= i < size
    // post: returns parent of node at location i
    {
        return (i-1)/2;
    }

    protected static int left(int i)
    // pre: 0 <= i < size
    // post: returns index of left child of node at location i
    {
        return 2*i+1;
    }

    protected static int right(int i)
    // pre: 0 <= i < size
    // post: returns index of right child of node at location i
    {
        return (2*i+1) + 1;
    }

    protected void percolateUp(int leaf)
    // pre: 0 <= leaf < size
    // post: moves node at index leaf up to appropriate position
    {
        int parent = parent(leaf);
        E value = DATOS.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(DATOS.get(parent)) < 0))
        {
            DATOS.set(leaf,DATOS.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        DATOS.set(leaf,value);
    }

    protected void pushDownRoot(int root)
    // pre: 0 <= root < size
    // post: moves node at index root down
    // to appropriate position in subtree
    {
        int heapSize = DATOS.size();
        E value = DATOS.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                        ((DATOS.get(childpos+1)).compareTo
                                (DATOS.get(childpos)) < 0))
                {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((DATOS.get(childpos)).compareTo
                        (value) < 0)
                {
                    DATOS.set(root,DATOS.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    DATOS.set(root,value);
                    return;
                }
            } else { // at a leaf! insert and halt
                DATOS.set(root,value);
                return;
            }
        }
    }
    
    @Override
    public E getFirst() {
        return DATOS.get(0);
    }

    @Override
    public E remove() {
        E valor_menor = getFirst();
        DATOS.set(0,DATOS.get(DATOS.size()-1));
        DATOS.setSize(DATOS.size()-1);
        if (DATOS.size() > 1){
            pushDownRoot(0);
        }
        return valor_menor;
    }

    @Override
    public void add(E value) {
        DATOS.add(value);
        percolateUp(DATOS.size()-1);
    }

    @Override
    public boolean isEmpty() {
        return DATOS.isEmpty();
    }

    @Override
    public int size() {
        return DATOS.size();
    }

    @Override
    public void clear() {
        DATOS = null;
    }
}
