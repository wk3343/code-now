package pers.wk.leetcode;

/**
 * 输入字符串，代表四则运算
 * 输出计算结果
 *
 * 思路是将运算式从加减号划分成多个段，然后计算每段乘除运算式的结果，累加到最终结果中。
 * 具体代码用了双指针。
 */
public class CalculateString {

    public static void main(String[] args) {
        System.out.println(calculate("1+2-3*4/5+7-8*9/10+0*9"));

    }

    private static int calculate(String input) {
        input = '+' + input;
        char[] chars = input.toCharArray();
        int l = 0;
        int r = 1;
        int result = 0;
        while (l < input.length()) {
            int currentResult = -1;
            String currentValue = "";
            char lastOperator = 0;
            while (r < input.length()) {
                if (Character.isDigit(chars[r])) {
                    currentValue = currentValue + chars[r];
                    if (r == input.length() -1) {
                        currentResult = getCurrentResult(currentResult, currentValue, lastOperator);
                        result = getResult(result, currentResult, chars[l]);
                        l = r + 1;
                        break;
                    }
                    r++;
                    continue;
                }
                if (chars[r] == '*' || chars[r] == '/') {
                    currentResult = getCurrentResult(currentResult, currentValue, lastOperator);
                    currentValue = "";
                    lastOperator = chars[r];
                    r++;
                    continue;
                }
                if (chars[r] == '+' || chars[r] == '-') {
                    currentResult = getCurrentResult(currentResult, currentValue, lastOperator);
                    result = getResult(result, currentResult, chars[l]);
                    l = r;
                    r++;
                    break;
                }

            }
        }
        return result;
    }

    private static int getResult(int result, int currentResult, char operator) {
        if (operator == '+') {
            result += currentResult;
        } else {
            result -= currentResult;
        }
        return result;
    }

    private static int getCurrentResult(int currentResult, String currentValue, char lastOperator) {
        if (currentResult == -1) {
            currentResult = Integer.valueOf(currentValue);
        } else if (lastOperator == '*') {
            currentResult = currentResult * Integer.valueOf(currentValue);
        } else if (lastOperator == '/') {
            currentResult = currentResult / Integer.valueOf(currentValue);
        }
        return currentResult;
    }

}
