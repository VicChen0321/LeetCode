class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int idxA = a.length() - 1;
        int idxB = b.length() - 1;
        int carry = 0;
        while (idxA >= 0 || idxB >= 0 || carry > 0) {
            if (idxA >= 0)
                carry += a.charAt(idxA--) - '0';
            if (idxB >= 0)
                carry += b.charAt(idxB--) - '0';
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }
}