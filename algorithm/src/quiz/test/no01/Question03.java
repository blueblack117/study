package quiz.test.no01;

/**
 * 당신은 소규모 컴퓨팅 시스템의 어셈블리 논리적 무결성을 테스트하려고 합니다.
 *
 * 이 시스템에는 레지스터(0~3번) 4개가 있습니다. 각 레지스터는 4비트로 이루어져 있어 0부터 15까지의 정수를 표현할 수 있습니다. 모든 레지스터는 처음에 0으로 초기화되어 있습니다.
 *
 * 당신은 CPU에 내리는 명령(instruction)이 주어지면 그 명령을 해석해서 가상의 레지스터 값을 변경해야 합니다. 명령은 0 이상 255 이하인 정수로 표현되며, 이를 8비트로 생각하면 각 비트를 다음과 같이 해석할 수 있습니다. (왼쪽이 상위비트, 오른쪽이 하위비트입니다.)
 *
 * 제일 왼쪽 2비트는 연산의 종류(opcode)를 나타냅니다.
 * opcode가 00 또는 01일 경우, 주어진 명령은 다음과 같이 해석됩니다.
 * 명령의 형식은 <opcode 2자리> <reg_a 2자리> <reg_b 2자리> <reg_c 2자리> 입니다.
 * opcode가 00일 경우, reg_a번 레지스터에 reg_b번 레지스터의 값을 넣습니다. 이때, reg_c의 값은 무시합니다.
 * opcode가 01일 경우, reg_a번 레지스터에 reg_b번 레지스터의 값과 reg_c번 레지스터의 값을 더한 값을 넣습니다.
 * opcode가 10 또는 11일 경우, 주어진 명령은 다음과 같이 해석됩니다.
 * 명령의 형식은 <opcode 2자리> <reg_a 2자리> <constant 4자리> 입니다.
 * opcode가 10일 경우, reg_a번 레지스터에 constant 값을 넣습니다.
 * opcode가 11일 경우, reg_a번 레지스터에 constant 값을 더해줍니다.
 * 참고로, 모든 레지스터는 0~15까지의 정수를 표현할 수 있으므로, 만약 두 값을 더했을 때 16 이상이 되는 경우에는, 오버플로우가 일어나서 하위 4비트만 남게 됩니다.
 *
 * 예를 들어서, 0번 레지스터에 5가 들어있고, 여기에 13을 더한다면, 0번 레지스터의 값은 18이 아니라 2가 됩니다.
 * 당신은 매 명령을 수행할 때 마다 각 레지스터에 들어있는 값들을 합쳐서 배열에 담아야 합니다. 이 때 여러 개의 값을 합친다는 것은, 0~3번 레지스터의 값들을 순서대로 비트 상으로 이어붙이고 이를 10진법으로 환산한다는 뜻입니다.
 *
 * 예를 들어, 0번 레지스터에 12(1100), 1번 레지스터에 6(0110), 2번 레지스터에 0(0000), 3번 레지스터에 5(0101)가 들어있다면, 4개의 레지스터 값들을 0번부터 3번까지 순서대로 비트 상으로 이어붙이면 1100011000000101 이 되므로, 이를 10진법으로 환산한 50693을 배열에 담아야 합니다.
 * 명령들이 담긴 배열 instructions이 주어질 때, 위 문단에 쓰여진 작업을 진행한 후 만들어진 배열을 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한 사항
 * instructions의 길이는 1 이상 10,000 이하입니다.
 * instructions에 들어있는 모든 수는 0 이상 255 이하입니다.
 * 입출력 예
 * instructions	result
 * [157,166,70,113,212,39,105]	[3328,3424,15712,15712,12640,12560,12576]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 각 명령들과 명령을 수행한 후 레지스터들의 값은 다음과 같습니다.
 * 명령(10진법)	명령(2진법)	opcode	reg_a	reg_b	reg_c	constant	R0	R1	R2	R3	결과 합산(2진법)	결과 합산(10진법)
 * 157	10011101	10	01	-	-	1101	0	13	0	0	0000110100000000	3328
 * 166	10100110	10	10	-	-	0110	0	13	6	0	0000110101100000	3424
 * 70	01000110	01	00	01	10	-	3	13	6	0	0011110101100000	15712
 * 113	01110001	01	11	00	01	-	3	13	6	0	0011110101100000	15712
 * 212	11010100	11	01	-	-	0100	3	1	6	0	0011000101100000	12640
 * 39	00100111	00	10	01	11	-	3	1	1	0	0011000100010000	12560
 * 105	01101001	01	10	10	01	-	3	1	2	0	0011000100100000	12576
 * 각 명령에 대한 자세한 설명은 다음과 같습니다.
 * 초기에는 모든 레지스터의 값들이 0으로 설정되어 있습니다.
 * 157은 opcode가 10인 명령으로, 1번 레지스터에 13을 넣는 명령입니다.
 * 따라서, 1번 레지스터의 값은 13이 됩니다.
 * 166은 opcode가 10인 명령으로, 2번 레지스터에 6을 넣는 명령입니다.
 * 따라서, 2번 레지스터의 값은 6이 됩니다.
 * 70은 opcode가 01인 명령으로, 0번 레지스터에 1번과 2번 레지스터의 값을 더한 값을 넣는 명령입니다.
 * 그러나, 1번 레지스터와 2번 레지스터의 값을 더하면 19이므로 오버플로우가 일어납니다.
 * 따라서 0번 레지스터의 값은 19의 하위 4비트에 해당하는 3이 됩니다.
 * 113은 opcode가 01인 명령으로, 3번 레지스터에 0번과 1번 레지스터의 값을 더한 값을 넣는 명령입니다.
 * 그러나, 0번 레지스터와 1번 레지스터의 값을 더하면 16이므로 오버플로우가 일어납니다.
 * 따라서 3번 레지스터의 값은 16의 하위 4비트에 해당하는 0이 됩니다.
 * 212는 opcode가 11인 명령으로, 1번 레지스터에 4를 더하는 명령입니다.
 * 그러나, 1번 레지스터의 현재 값은 13이므로 여기에 4를 더하면 오버플로우가 일어납니다.
 * 따라서 1번 레지스터의 값은 17의 하위 4비트에 해당하는 1이 됩니다.
 * 39는 opcode가 00인 명령으로, 2번 레지스터에 1번 레지스터의 값을 넣는 명령입니다.
 * 따라서 2번 레지스터의 값은 1이 됩니다.
 * 105는 opcode가 01인 명령으로, 2번 레지스터에 2번 레지스터와 1번 레지스터의 값을 더한 값을 넣는 명령입니다.
 * 따라서 2번 레지스터의 값은 2가 됩니다.
 */
public class Question03 {

    public static void main(String[] args) {
        Question03 alg = new Question03();

        int[] test = new int[] {157,166,70,113,212,39,105};
        alg.printResult(alg.solution(test));
        // 3328,3424,15712,15712,12640,12560,12576
    }

    public int[] solution(int[] instructions) {
        int[] register = new int[] {0, 0, 0, 0};

        int[] answer = new int[instructions.length];
        for (int inx=0; inx<instructions.length; inx++) {
            String strInc = toBinary(instructions[inx], 8);
            if (strInc.startsWith("00")) {
                String regA = strInc.substring(2,4);
                String regB = strInc.substring(4,6);

                register[Integer.parseInt(regA, 2)] = register[Integer.parseInt(regB, 2)];
            } else if (strInc.startsWith("01")) {
                String regA = strInc.substring(2,4);
                String regB = strInc.substring(4,6);
                String regC = strInc.substring(6,8);

                register[Integer.parseInt(regA, 2)] = (register[Integer.parseInt(regB, 2)] + register[Integer.parseInt(regC, 2)]) % 16;
            } else if (strInc.startsWith("10")) {
                String regA = strInc.substring(2,4);
                String constant = strInc.substring(4,8);

                register[Integer.parseInt(regA, 2)] = Integer.parseInt(constant, 2);
            } else if (strInc.startsWith("11")) {
                String regA = strInc.substring(2,4);
                String constant = strInc.substring(4,8);

                register[Integer.parseInt(regA, 2)] = (register[Integer.parseInt(regA, 2)] + Integer.parseInt(constant, 2)) % 16;
            }
            answer[inx] = calculate(register);
        }
        return answer;
    }

    public String toBinary(int b, int digit) {
        String res = Integer.toBinaryString(b);
        while (res.length() < digit) res = "0" + res;
        return res;
    }

    public int calculate(int[] registers) {
        StringBuffer sb = new StringBuffer();
        for (int register : registers) {
            sb.append(toBinary(register, 4));
        }
        String binaryString = sb.toString();
        int result = Integer.parseInt(binaryString, 2);
        return result;
    }

    public void printResult(int[] answer) {
        for (int inx=0; inx<answer.length; inx++) {
            System.out.print(answer[inx] + ",");
        }
        System.out.println();
    }
}
