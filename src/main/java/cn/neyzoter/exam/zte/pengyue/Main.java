package cn.neyzoter.exam.zte.pengyue;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * 中兴捧月比赛
 * @author Charles Song
 * @date 2020-4
 */
public class Main {
    public static void main (String[] args) {
        try {
            Information info = new Information("/home/scc/code/java/oj/src/main/java/cn/neyzoter/exam/zte/pengyue/test/case1/topoAndRequest1.txt");
            System.out.println(info);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

/**
 * 信息获取
 */
class Information {
    /**
     * 输入的分隔符
     */
    private static final String IN_SPLITER = ",";
    /**
     * 两个站点间的分隔符，用于创建HashMap的Key
     */
    private static final String STATE_SPLITER = "_";
    /**
     * 没有必须要到达的站点
     */
    private static final String NULL_MUST_ARRIVED_STATE = "null";
    /**
     * 站点个数
     */
    private int stateNum;
    /**
     * 轨道条数
     */
    private int railwayNum;

    /**
     * 列车数目
     */
    private int trainNum;
    /**
     * 列车容量 T
     */
    private double trainCap;
    /**
     * 每个站点的拣货员
     */
    private Map<String, Integer> stateStuff;
    /**
     * 站点连接信息
     */
    private Map<String, String> stateCon;

    /**
     * 货物的信息
     */
    private Map<String, Good> goodMap;

    Information () {
        InputStream is = System.in;
        update(is);
    }
    Information (String path) throws Exception {
        try (InputStream is = new FileInputStream(path)) {
            update(is);
        } catch (Exception e) {
            System.err.println(e);
            throw e;
        }
    }

    /**
     * 更新信息
     * @param is 输入
     */
    public void update (InputStream is) {
        Scanner sc = new Scanner(is);
        // 第一行信息
        String baseInfoLine = sc.nextLine();
        String[] line1Spl = baseInfoLine.split(IN_SPLITER);
        int stateNumRead = Integer.parseInt(line1Spl[0]);setStateNum(stateNumRead);
        int railwayNumRead = Integer.parseInt(line1Spl[1]);setRailwayNum(railwayNumRead);
        int trainNumRead = Integer.parseInt(line1Spl[2]);setTrainNum(trainNumRead);
        double trainCapRead =Double.parseDouble(line1Spl[3]);setTrainCap(trainCapRead);
        // 拣货员信息
        stateStuff = new HashMap<>(stateNumRead);
        for (int i = 0 ; i < stateNumRead ; i ++) {
            String stateInfo = sc.nextLine();
            String[] stateInfoSpl = stateInfo.split(IN_SPLITER);
            String stateName = stateInfoSpl[0];
            int stuffNum = Integer.parseInt(stateInfoSpl[1]);
            stateStuff.put(stateName, stuffNum);
        }
        // 站点连接信息
        stateCon = new HashMap<>(railwayNumRead);
        for (int i = 0; i < railwayNumRead ; i ++) {
            String conInfo = sc.nextLine();
            String[] conInfoSpl = conInfo.split(IN_SPLITER);
            String state2state = conInfoSpl[1] + STATE_SPLITER + conInfoSpl[2];
            String railway = conInfoSpl[0];
            stateCon.put(state2state, railway);

        }
        // 货物数目
        int goodNum = Integer.parseInt(sc.nextLine());
        goodMap = new HashMap<>(goodNum);
        for (int i = 0 ; i < goodNum ; i ++) {
            String goodInfo = sc.nextLine();
            String[] goodInfoSpl = goodInfo.split(IN_SPLITER);
            String goodName = goodInfoSpl[0];
            String sourceState = goodInfoSpl[1];
            String destState = goodInfoSpl[2];
            Double goodWeight = Double.parseDouble(goodInfoSpl[3]);
            Set<String> mustArrived = new HashSet<>();
            if (!NULL_MUST_ARRIVED_STATE.equals(goodInfoSpl[4])) {
                int mustArrivedNum = goodInfoSpl.length;
                for (int j = 4 ; j < mustArrivedNum ; j ++) {
                    mustArrived.add(goodInfoSpl[j]);
                }
            }
            Good good = new Good(goodName, sourceState, destState, goodWeight, mustArrived);
            goodMap.put(goodName, good);
        }
    }

    public int getStateNum() {
        return stateNum;
    }

    public void setStateNum(int stateNum) {
        this.stateNum = stateNum;
    }

    public int getRailwayNum() {
        return railwayNum;
    }

    public void setRailwayNum(int railwayNum) {
        this.railwayNum = railwayNum;
    }

    public int getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(int trainNum) {
        this.trainNum = trainNum;
    }

    public double getTrainCap() {
        return trainCap;
    }

    public void setTrainCap(double trainCap) {
        this.trainCap = trainCap;
    }

    public Map<String, Integer> getStateStuff() {
        return stateStuff;
    }

    public Map<String, String> getStateCon() {
        return stateCon;
    }

    public Map<String, Good> getGoodMap() {
        return goodMap;
    }
}

/**
 * 货物信息
 * @author Charles Song
 * @date 2020-4-24
 */
class Good {
    /**
     * 货物名称
     */
    private String name;
    /**
     * 开始车站
     */
    private String sourceState;
    /**
     * 目的车站
     */
    private String destState;
    /**
     * 货物重量 T
     */
    private Double weight;
    /**
     * 必须到达的站点
     */
    private Set<String> mustArrivedState;

    Good (String name, String sc, String dest, Double weight, Set<String> mustArrivedState) {
        this.name = name;
        this.sourceState = sc;
        this.destState = dest;
        this.weight = weight;
        this.mustArrivedState = mustArrivedState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSourceState() {
        return sourceState;
    }

    public void setSourceState(String sourceState) {
        this.sourceState = sourceState;
    }

    public String getDestState() {
        return destState;
    }

    public void setDestState(String destState) {
        this.destState = destState;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Set<String> getMustArrivedState() {
        return mustArrivedState;
    }

    public void setMustArrivedState(Set<String> mustArrivedState) {
        this.mustArrivedState = mustArrivedState;
    }


}

class EvalUtil {
    /**
     * 分数获取
     * @param bw 没有被分配的货物重量
     */
    public static Double score (List<Double> bw) {
        Double score = 0.0;
        for (Double w : bw) {
            score += (1 + w / 100);
        }
        return score;
    }
}
