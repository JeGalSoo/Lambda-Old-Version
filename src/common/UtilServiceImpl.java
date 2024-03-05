package common;

import lombok.Getter;

public class UtilServiceImpl implements UtilService {

    @Getter
    private static UtilService instance = new UtilServiceImpl();

    private UtilServiceImpl() {
    } //디폴트 생성자를 막음

    @Override
    public int createRandomInteger(int start, int gapBetweenStarAndEnd) {
        //0이상 50미만의 값을 생성하고 150을 더해줌으로써 키의 범위를 150이상 200미만으로 만듦.
        return start + (int) (Math.random() * gapBetweenStarAndEnd);
    }

    @Override
    public double createRandomDouble(double start, double gapBetweenStartAndEnd) {
        return start + (Math.random() * gapBetweenStartAndEnd);
    }

    @Override
    public String createRandomName() {
        String[] names = {"이정재", "마동석", "송강호", "윤여정", "황정민", "정우성",
                "이병헌", "현 빈", "유해진", "손석구", "전도연", "손예진",
                "하지원", "김하늘", "송중기", "하정우", "장동건", "원 빈", "박해일",
                "소지섭", "김혜수"};
        return names[createRandomInteger(0,20)];
    }

    @Override
    public String createRandomTitle() {
        String[] title = {"공개하지 아니한",
                "회의내용의 공표에",
                "관하여는 법률이 정하는 바에 의한다.",
                "재판의 전심절차로서 행정심판을",
                "할 수 있다.",
                "행정심판의 절차는 법률로 정하되",
                "사법절차가 준용되어야 한다.",
                "대통령은 제3항과 제4항의",
                "사유를 지체없이 공포하여야 한다.",
                "국가는 과학기술의",
                "혁신과 정보 및 인력의",
                "개발을 통하여 국민경제의",
                "발전에 노력하여야 한다."};
        return title[createRandomInteger(0,12)];
    }

    @Override
    public String createRandomContents() {
        String[] text={"1사회적 특수계급의 제도는 인정되지 아니하며",
                "1어떠한 형태로도 이를 창설할 수 없다.",
                "1국방상 또는 국민경제상 긴절한 필요로 인하여",
                "1법률이 정하는 경우를 제외하고는",
                "1사영기업을 국유 또는 공유로 이전하거나",
                "1그 경영을 통제 또는 관리할 수 없다.",
                "1정당의 설립은 자유이며, 복수정당제는 보장된다.",
                "1이 헌법중 공무원의 임기 또는 중임제한에 관한 규정은",
                "1이 헌법에 의하여 그 공무원이 최초로 선출 또는 임명된 때로부터 적용한다.",
                "1국회에 제출된 법률안 기타의 의안은 회기중에 의결되지 못한 이유로 폐기되지 아니한다.",
                "1다만, 국회의원의 임기가 만료된 때에는 그러하지 아니하다.",
                "1나는 헌법을 준수하고 국가를 보위하며 조국의 평화적 통일과",
                "1국민의 자유와 복리의 증진 및 민족문화의 창달에 노력하여 대통령으로서의",
                "1직책을 성실히 수행할 것을 국민 앞에 엄숙히 선서합니다."};
        return text[createRandomInteger(0,13)];
    }

    @Override
    public String createRandomJob() {
        String[] names = {"경찰", "소방관", "세일즈맨", "교수", "회계사",
                "공무원", "의사"};
        return names[createRandomInteger(0,6)];
    }

    @Override
    public String createRandomUsername() {
        String username = "";
        for(int i = 0; i < 5; i++)
            username += String.valueOf((char)('a' + createRandomInteger(0, 26)));
        return username;
    }
}