package com.example.http.rx;

/**
 * @author Li
 * @data 2017年12月4日
 * @Email 364797468@qq.com
 * @describe
 * 定义一个请求实体基类
 */

public class BaseResultEntity<T> {
    /**
     * returnCode : 0
     * returnMsg : 获取成功
     * data : [{"id":"12194","type":"4","stype":"1","uid":"378","title":"最近网络火的一位灵魂舞者 \u2026 舞是正经的，人正不正经就不知道了❤❤","describe":"最近网络火的一位灵魂舞者 \u2026 舞是正经的，人正不正经就不知道了❤❤","cover":"/Upload/cover/2017-11-10/1510280705_8118.jpg","sImages":"","videoUrl":"/Upload/square/2017-11-10/1510280480_9998.mp4","audioUrl":"","clickNum":320,"vclickNum":"272","likeNum":"4","commentNum":"3","createTime":"1510280705","nickname":"Li","avatar":"/Upload/avatar/2017-07-19/1500466701_5175.png","userLevel":"4","daren":"1","master":"1","likeState":"1","concern":"2"},{"id":"10360","type":"4","stype":"1","uid":"378","title":"子龙老师开场白","describe":"子龙老师开场白","cover":"/Upload/cover/2017-11-02/1509593168_7790.jpg","sImages":"","videoUrl":"/Upload/square/2017-11-02/1509592823_7167.mp4","audioUrl":"","clickNum":35,"vclickNum":"0","likeNum":"7","commentNum":"10","createTime":"1509593169","nickname":"Li","avatar":"/Upload/avatar/2017-07-19/1500466701_5175.png","userLevel":"4","daren":"1","master":"1","likeState":"1","concern":"2"},{"id":"10215","type":"4","stype":"1","uid":"378","title":"一睹张锦江，范芳丽，饶子龙，心语，小辉，晏子，春兰老师风采！","describe":"一睹张锦江，范芳丽，饶子龙，心语，小辉，晏子，春兰老师风采！","cover":"/Upload/cover/2017-11-01/1509518535_9589.jpg","sImages":"","videoUrl":"/Upload/square/2017-11-01/1509517217_4040.mp4","audioUrl":"","clickNum":34,"vclickNum":"0","likeNum":"7","commentNum":"6","createTime":"1509518536","nickname":"Li","avatar":"/Upload/avatar/2017-07-19/1500466701_5175.png","userLevel":"4","daren":"1","master":"1","likeState":"1","concern":"2"},{"id":"10185","type":"4","stype":"1","uid":"378","title":"活动现场","describe":"活动现场","cover":"/Upload/cover/2017-11-01/1509511817_5571.jpg","sImages":"","videoUrl":"/Upload/square/2017-11-01/1509511739_8764.mp4","audioUrl":"","clickNum":24,"vclickNum":"0","likeNum":"6","commentNum":"2","createTime":"1509511817","nickname":"Li","avatar":"/Upload/avatar/2017-07-19/1500466701_5175.png","userLevel":"4","daren":"1","master":"1","likeState":"1","concern":"2"},{"id":"9977","type":"4","stype":"1","uid":"5","title":"广场舞世界，世界的广场舞，可惜泰国的阿姨们没有我们的广场舞神器","describe":"广场舞世界，世界的广场舞，可惜泰国的阿姨们没有我们的广场舞神器","cover":"/Upload/cover/2017-10-30/1509361562_3785.jpg","sImages":"","videoUrl":"/Upload/square/2017-10-30/1509361463_4943.mp4","audioUrl":"","clickNum":26,"vclickNum":"0","likeNum":"3","commentNum":"4","createTime":"1509361562","nickname":"和光同尘","avatar":"/Upload/avatar/2017-05-26/20170526113238_9508.jpg","userLevel":"4","daren":"1","master":"1","likeState":"1","concern":"1"},{"id":"6234","type":"4","stype":"1","uid":"378","title":"一直很喜欢的一位韩国天才吉他手-郑成河。\n作品:Canon (卡农) 和大家分享[爱你]","describe":"一直很喜欢的一位韩国天才吉他手-郑成河。\n作品:Canon (卡农) 和大家分享[爱你]","cover":"/Upload/cover/2017-10-11/1507694999_6220.jpg","sImages":"","videoUrl":"/Upload/square/2017-10-11/1507694636_1897.mp4","audioUrl":"","clickNum":79,"vclickNum":"0","likeNum":"7","commentNum":"5","createTime":"1507694999","nickname":"Li","avatar":"/Upload/avatar/2017-07-19/1500466701_5175.png","userLevel":"4","daren":"1","master":"1","likeState":"1","concern":"2"},{"id":"3266","type":"4","stype":"1","uid":"1479","title":"","describe":"","cover":"/Upload/cover/2017-09-09/1504925409_1514.png","sImages":"","videoUrl":"/Upload/square/2017-09-09/1504925395_6664.mp4","audioUrl":"","clickNum":49,"vclickNum":"0","likeNum":"10","commentNum":"10","createTime":"1504925410","nickname":"AmuletFortune","avatar":"/Upload/avatar/2017-07-12/1499820047_8292.png","userLevel":"3","daren":"1","master":"1","likeState":"1","concern":"1"},{"id":"2031","type":"4","stype":"1","uid":"126","title":"搞笑","describe":"","cover":"/Upload/cover/2017-08-27/1503815642_9334.png","sImages":"","videoUrl":"/Upload/square/2017-08-27/1503766338_9854.mp4","audioUrl":"","clickNum":131,"vclickNum":"0","likeNum":"3","commentNum":"1","createTime":"1503766339","nickname":"欢喜妹","avatar":"/Upload/avatar/2017-05-26/1495782886_5183.png","userLevel":"4","daren":"1","master":"1","likeState":"1","concern":"2"},{"id":"1985","type":"4","stype":"1","uid":"378","title":"有没有被小公举萌到","describe":"有没有被小公举萌到","cover":"/Upload/cover/2017-08-27/1503820344_3840.png","sImages":"","videoUrl":"/Upload/square/2017-08-26/1503739230_5221.mp4","audioUrl":"","clickNum":215,"vclickNum":"0","likeNum":"12","commentNum":"17","createTime":"1503739230","nickname":"Li","avatar":"/Upload/avatar/2017-07-19/1500466701_5175.png","userLevel":"4","daren":"1","master":"1","likeState":"1","concern":"2"},{"id":"1807","type":"4","stype":"1","uid":"5","title":"跳吧，你就更年轻。","describe":"跳吧，你就更年轻。","cover":"/Upload/cover/2017-08-24/1503576024_3345.png","sImages":"","videoUrl":"/Upload/square/2017-08-24/1503574579_3068.mp4","audioUrl":"","clickNum":76,"vclickNum":"0","likeNum":"11","commentNum":"7","createTime":"1503574580","nickname":"和光同尘","avatar":"/Upload/avatar/2017-05-26/20170526113238_9508.jpg","userLevel":"4","daren":"1","master":"1","likeState":"1","concern":"1"}]
     */
    private int returnCode;
    private String returnMsg;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }


}
