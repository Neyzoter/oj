package cn.neyzoter.exam.zte.pengyue;

import io.netty.handler.codec.http.HttpServerKeepAliveHandler;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 中兴捧月比赛
 * @author Charles Song
 * @date 2020-4
 */
public class Main {
    public static void main (String[] args) {
        Information info = new Information();
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
    private HashMap<String, Integer> stateStuff;
    /**
     * 站点连接信息
     */
    private HashMap<String, String> stateCon;

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
        int goodNum = sc.nextInt();
        for (int i = 0 ; i < goodNum ; i ++) {
            String goodInfo = sc.nextLine();
            String[] goodInfoSpl = goodInfo.split(IN_SPLITER);
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

    public HashMap<String, Integer> getStateStuff() {
        return stateStuff;
    }
}
