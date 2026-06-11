class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        addingPar(res, "", n, 0);
        return res;
    }

    private void addingPar(List<String> res, String str, int n, int m) {
        if (n == 0 && m == 0) {
            res.add(str);
            return;
        }

        if (m > 0) {
            addingPar(res, str + ")", n, m - 1);
        }

        if (n > 0) {
            addingPar(res, str + "(", n - 1, m + 1);
        }
    }
}