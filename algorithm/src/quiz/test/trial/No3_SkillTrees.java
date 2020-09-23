package quiz.test.trial;

/**
 * 선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
 *
 * 예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
 *
 * 위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.
 *
 * 선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
 *
 * 제한 조건
 * •스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
 * •스킬 순서와 스킬트리는 문자열로 표기합니다. ◦예를 들어, C → B → D 라면 “CBD”로 표기합니다
 *
 * •선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
 * •skill_trees는 길이 1 이상 20 이하인 배열입니다.
 * •skill_trees의 원소는 스킬을 나타내는 문자열입니다.
 * ◦skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
 *
 *
 * 입출력 예 설명
 * •“BACDE”: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
 * •“CBADF”: 가능한 스킬트리입니다.
 * •“AECB”: 가능한 스킬트리입니다.
 * •“BDA”: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.
 *
 */
public class No3_SkillTrees {

    //정확성: 20.0
    //효율성: 0.0
    //합계: 20.0 / 20.0
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int jnx=0; jnx<skill_trees.length; jnx++) {
            String cmpString = skill_trees[jnx];
            boolean accept = true;
            int fromIndex = -1;
            for (int inx=0; inx<cmpString.length(); inx++) {
                char codeSkill = cmpString.charAt(inx);
                if (skill.indexOf(codeSkill) >= 0) {
                    int inxSkillCode = skill.indexOf(codeSkill, fromIndex);
                    if (inxSkillCode >= 0 && (inxSkillCode == fromIndex+1)) {
                        fromIndex = skill.indexOf(codeSkill, fromIndex);
                    } else {
                        accept = false;
                    }
                }
            }
            if (accept) {
                answer++;
                System.out.println("accept skill-tree = " + cmpString);
            }
        }

        return answer;
    }

    // 8.6 / 20.0
    public int solution2(String skill, String[] skill_trees) {
        int answer = 0;


        for (int jnx=0; jnx<skill_trees.length; jnx++) {
            String cmpString = skill_trees[jnx];
            boolean accept = true;
            int fromIndex = 0;
            for (int inx=0; inx<skill.length(); inx++) {
                char codeSkill = skill.charAt(inx);
                if (cmpString.indexOf(codeSkill, fromIndex) >= 0) {
                    fromIndex = cmpString.indexOf(codeSkill, fromIndex);
                } else {
                    if ((cmpString.length()-1) <= fromIndex) {
                        // skip
                    } else {
                        accept = false;
                    }
                }
            }
            if (accept) {
                answer++;
                System.out.println("accept skill-tree = " + cmpString);
            }
        }

        return answer;
    }

    //정확성: 20.0
    //효율성: 0.0
    //합계: 20.0 / 20.0
    public int solution3(String skill, String[] skill_trees) {
        int answer = 0;
        int treeLength = skill_trees.length;
        for(int i=0; i<treeLength; i++){
            int skillIndex=0;
            boolean flag = true;

            int treeIdxLength = skill_trees[i].length();
            for(int j=0; j<treeIdxLength; j++){
                int skillLength = skill.length();
                for(int k=skillIndex; k<skillLength; k++){
                    if(skill.charAt(k) == skill_trees[i].charAt(j)){
                        if(k!=skillIndex){
                            flag = false;
                        }else{
                            skillIndex++;
                        }

                    }
                }
            }

            if(flag == true){
                answer ++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        No3_SkillTrees alg = new No3_SkillTrees();
        String[] skillTrees = new String[] {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(alg.solution("CBD", skillTrees));
        System.out.println(alg.solution2("CBD", skillTrees));
        System.out.println(alg.solution3("CBD", skillTrees));
    }
}
