/**
 * @author Linzeyu
 * @create 2020-10-31 15:39
 * @describe ���ģʽ
 * @state todo
 */
public class H_FacadePattern {
    public static void main(String[] args) {
        GovernmentAffairsCenter governmentAffairsCenter = new GovernmentAffairsCenter();
        boolean prove = governmentAffairsCenter.prove();
    }
}

// �ֵ���
class StreetOffice {
    boolean isOK() {
        return true;
    }
}

// ��λ
class Employer {
    boolean isOK() {
        return true;
    }
}

// �ɳ���
class PoliceStation {
    boolean isOK() {
        return true;
    }
}

/**
 * ���ģʽ�ࣨ�������ģ�
 * ��ԭ���߼����з�װ
 */
class GovernmentAffairsCenter {

    StreetOffice streetOffice = new StreetOffice();
    Employer employer = new Employer();
    PoliceStation policeStation = new PoliceStation();

    boolean prove() {
        return streetOffice.isOK() && employer.isOK() && policeStation.isOK();
    }
}
