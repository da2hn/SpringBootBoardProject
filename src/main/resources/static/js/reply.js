let replyService = (function(){

    function add(reply, callback){
        console.log("add reply.........");
        console.log(reply);
        $.ajax({
            url: "/reply/new",
            type: "post",
            data: JSON.stringify(reply),
            contentType: "application/json",
            success: function(result){
                if(callback){
                    callback(result);
                }
            }
        });
    }

    function getList(param, callback){
        let boardNumber = param.boardNumber;
        let page = param.page || 1;

        $.getJSON("/reply/list/" + boardNumber + "/" + page, function(replyPageDTO){
            if(callback){
                callback(replyPageDTO.list, replyPageDTO.total);
            }
        });
    }

    function read(replyNumber, callback){
        $.get("/reply/" + replyNumber, function(reply){
            if(callback){
                callback(reply);
            }
        });
    }

    function remove(replyNumber, callback){
        $.ajax({
            url: "/reply/" + replyNumber,
            type: "delete",
            success: function(result){
                if(callback){
                    callback(result);
                }
            }
        });
    }

    function modify(reply, callback){
        $.ajax({
            url: "/reply/" + reply.replyNumber,
            type: "PUT",
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function(result){
                if(callback){
                    callback(result);
                }
            }
        });
    }

    function getReplyDate(replyDate){
        let today = new Date();
        let rDate = new Date(replyDate);
        let gap = today.getTime() - rDate.getTime();

        if(gap < 1000 * 60 * 60 * 24){
            let h = rDate.getHours();
            let m = rDate.getMinutes();
            let s = rDate.getSeconds();

            return [(h < 10 ? '0' : '') + h, (m < 10 ? '0' : '') + m, (s < 10 ? '0' : '') + s].join(":");
        }else{
            let y = rDate.getFullYear();
            let m = rDate.getMonth() + 1;
            let d = rDate.getDate();

            return [y, (m < 10 ? '0' : '') + m, (d < 10 ? '0' : '') + d].join("-")
        }
    }
    
    return {add: add, getList: getList, read: read, remove: remove, modify: modify, getReplyDate: getReplyDate};
})();