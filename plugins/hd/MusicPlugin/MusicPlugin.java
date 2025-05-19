
进口com.alibaba.fastjson2.JSON；
进口com.alibaba.fastjson2.JSONObject；
进口com.alibaba.fastjson2.JSONPath；

进口我。高清。wauxv.plugin.API.callback.PluginCallBack；

无效的 sendMusic(线 说话的人,线 标题) {
    得到("https://api.vkeys.cn/v2/music/netease?word="+标题+"选择=1(&S)",无效的,新的 PluginCallBack.HttpCallback() {
        公共 无效的 onSuccess(int respCode,线 respContent) {
            JSONObject JSONObject=JSON。parseObject(respContent);
            线 身份标识=JSONPath。eval(JSONObject，"$.data.id").toString();
            线 姓名=JSONPath。eval(JSONObject，"$.data.song");
            线 歌手=JSONPath。eval(JSONObject，"$.data.singer");
            线 URL=JSONPath。eval(JSONObject，"$.data.url");
            线 链接=JSONPath。eval(JSONObject，"$.data.link");
            sendMusicCard(说话人，名字，歌手，url，链接，"wx8dd6ecd81906fd84");
        }

        公共 无效的 onError(例外 e) {
            sendText(说话的人，"[落月API]请求异常："+e.getMessage());
        }
    });
}

无效的 onHandleMsg(对象 msgInfoBean) {
    如果 (msgInfoBean。IsText()) {
        线 内容=msgInfoBean。getContent();
        线 说话的人=msgInfoBean。getTalker();
        如果 (内容。startswith("/点歌 ")) {
            线 标题=内容。子字串(4);
            sendMusic(谈话者，标题);
        }
    }
}
