/**
 * http://www.geeksforgeeks.org/greedy-algorithms-set-3-huffman-coding/
 * http://www.geeksforgeeks.org/greedy-algorithms-set-3-huffman-coding-set-2/
 */
public class HuffmanEncoding {

	public Map<Character, String> huffman(char[] values, int[] freq) {

		HuffmanNodeComparator comparator = new HuffmanNodeComparator();
		PriorityQueue<HuffmanNode> heap = new PriorityQueue<HuffmanNode>(input.length + 1, comparator);
		for (int i = 0; i < values.length; i++) {
			heap.offer(new HuffmanNode(values[i], freq[i]));
		}

		while(heap.size() > 1){
			HuffmanNode n1 = heap.poll();
			HuffmanNode n2 = heap.poll();
			HuffmanNode parent = new HuffmanNode(n1.freq + n2.freq);
			parent.left = n1;
			parent.right = n2;
			heap.offer(parent);
		}

		Map<Character, String> mapping = new HashMap<Character, String>();
		encode(heap.poll(), mapping, new StringBuffer());

		return mapping;
	}

	public void encode(HuffmanNode root, Map<Character, String> mapping, StringBuffer sb){
		if(root == null){
			return;
		}

		if(root.left == null && root.right == null){
			map.put(root.value, sb.toString());
			return;
		}

		sb.append("1");
		encode(root.left, map, sb);
		sb.deleteCharAt(sb.length() - 1);

		sb.append("0");
		encode(root.right, map, sb);
		sb.deleteCharAt(sb.length() - 1);
	}

    static class HuffmanNode{
    	int freq;
    	char value;
    	HuffmanNode left;
    	HuffmanNode right;

        public HuffmanNode(int freq) {
            this(0, freq);
        }

        public HuffmanNode(char value, int freq) {
            this.value = value;
            this.freq = freq;
            this.left = null;
            this.right = null;
        }
    }

    static class HuffmanNodeComparator implements Comparator<HuffmanNode>{
    	@Override
    	public int compare(HuffmanNode n1, HuffmanNode n2) {
            return n1.freq - n2.freq;
    	}
    }
}
