class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        // System.out.println(Arrays.toString(products));
        List<List<String>> result = new ArrayList<>();
        int bsStart = 0;
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            int start = binarySearchRight(products, prefix, bsStart);
            // System.out.println("start = " + start);
            List<String> found = new ArrayList();
            for (int i = start; i < Math.min(start + 3, products.length); i ++) {
                if (products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix))
                    break;
                found.add(products[i]);
            }
            result.add(found);
            bsStart = start;
        }
        return result;
    }
    
    private int binarySearchRight (String[] products, String target, int bsStart) {
        int left = bsStart;
        int right = products.length - 1;
        int ind = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // System.out.println("mid: " + products[mid] + " target: " + target);
            // System.out.println("compare result = " + products[mid].compareTo(target));
            if (products[mid].compareTo(target) >= 0) {
                right = mid - 1;
                ind = mid;
            } else {
                left = mid + 1;
            }
        }
        return ind;
    }
}