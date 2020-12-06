/**
 * @author Linzeyu
 * @create 2020-10-31 15:39
 * @describe 外观模式
 * @state todo
 */
public class H_FacadePattern {
    public static void main(String[] args) {
        GovernmentAffairsCenter governmentAffairsCenter = new GovernmentAffairsCenter();
        boolean prove = governmentAffairsCenter.prove();
    }
}

// 街道办
class StreetOffice {
    boolean isOK() {
        return true;
    }
}

// 单位
class Employer {
    boolean isOK() {
        return true;
    }
}

// 派出所
class PoliceStation {
    boolean isOK() {
        return true;
    }
}

/**
 * 外观模式类（政务中心）
 * 对原有逻辑进行封装
 */
class GovernmentAffairsCenter {

    StreetOffice streetOffice = new StreetOffice();
    Employer employer = new Employer();
    PoliceStation policeStation = new PoliceStation();

    boolean prove() {
        return streetOffice.isOK() && employer.isOK() && policeStation.isOK();
    }
}
