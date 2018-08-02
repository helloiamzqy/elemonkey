package com.monkey.ele.merchant.controller;

import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.merchant.pojo.Comment;
import com.monkey.ele.merchant.pojo.Message;
import com.monkey.ele.merchant.pojo.Store;
import com.monkey.ele.merchant.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 9:13 PM 8/2/2018
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public ResponseMessage addStore(@RequestBody Comment comment) throws Exception {
        ResponseMessage respMsg = null;
        Comment addComment = commentService.addComment(comment);
        if (addComment == null) {
            respMsg = new ResponseMessage(null, MessageResultCode.FAILED, Message.MSG_ADD_ERROR);
        } else {
            respMsg = new ResponseMessage(addComment, MessageResultCode.SUCCESS, Message.MSG_ADD_SUCCESS);
        }
        return respMsg;
    }

    @RequestMapping(value = "/store/{storeId}", method = RequestMethod.GET)
    public ResponseMessage getStoreComments(@PathVariable("storeId") String storeId) {
        List<Comment> comments = commentService.watchComments(storeId);
        ResponseMessage respMsg = new ResponseMessage(comments, MessageResultCode.SUCCESS, null);
        return respMsg;
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public ResponseMessage getOrderComment(@PathVariable("orderId") String orderId) {
        Comment comment = commentService.watchOrderComment(orderId);
        ResponseMessage respMsg = new ResponseMessage(comment, MessageResultCode.SUCCESS, null);
        return respMsg;
    }
}
