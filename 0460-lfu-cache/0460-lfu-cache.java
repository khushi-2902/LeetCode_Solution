class LFUCache {

    class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLL {

        Node head;
        Node tail;
        int size;

        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void add(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {

            if (size == 0)
                return null;

            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    int capacity;
    int minFreq;

    HashMap<Integer, Node> keyMap;
    HashMap<Integer, DLL> freqMap;

    public LFUCache(int capacity) {

        this.capacity = capacity;

        keyMap = new HashMap<>();
        freqMap = new HashMap<>();

        minFreq = 0;
    }

    public int get(int key) {

        if (!keyMap.containsKey(key))
            return -1;

        Node node = keyMap.get(key);

        update(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0)
            return;

        if (keyMap.containsKey(key)) {

            Node node = keyMap.get(key);

            node.value = value;

            update(node);

            return;
        }

        if (keyMap.size() == capacity) {

            DLL list = freqMap.get(minFreq);

            Node removeNode = list.removeLast();

            keyMap.remove(removeNode.key);
        }

        Node node = new Node(key, value);

        keyMap.put(key, node);

        DLL list = freqMap.getOrDefault(1, new DLL());

        list.add(node);

        freqMap.put(1, list);

        minFreq = 1;
    }

    private void update(Node node) {

        int freq = node.freq;

        DLL oldList = freqMap.get(freq);

        oldList.remove(node);

        if (freq == minFreq && oldList.size == 0)
            minFreq++;

        node.freq++;

        DLL newList = freqMap.getOrDefault(node.freq, new DLL());

        newList.add(node);

        freqMap.put(node.freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */