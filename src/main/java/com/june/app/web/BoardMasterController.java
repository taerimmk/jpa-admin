
package com.june.app.web;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.june.app.model.BoardMaster;
import com.june.app.service.BoardMasterService;

/**
 * @author Trk
 */
@Controller
public class BoardMasterController extends CommonController {

	@Autowired
	private BoardMasterService boardMasterService;

	@RequestMapping(value = { "/boardMaster/list/{pageIndex}",
			"/boardMaster/list/{pageIndex}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String boardMasters(Map<String, Object> model, BoardMaster boardMaster, HttpServletRequest reques,
			@PathVariable("pageIndex") int pageIndex, @PathVariable Map<String, String> pathVariables,
			SessionStatus status) {

		/** 페이지당 보여주는 게시물 수 */
		boardMaster.setPageSize(10);
		/** 현재 페이지 */
		boardMaster.setPageIndex(pageIndex);
		/** 게시판 LIST */
		Collection<BoardMaster> boardMasters = boardMasterService.getBoardMasterList(boardMaster);
		int totalCnt = boardMasterService.getBoardMasterListCnt(boardMaster);
		boardMaster.setTotalCnt(totalCnt);
		model.put("boardMasters", boardMasters);
		model.put("sideMenu", "3");
		model.put("sideMenuSub", "3");
		status.setComplete();
		return "boardMaster/boardMasterList";
	}

	@RequestMapping(value = "/boardMaster/put", method = RequestMethod.GET)
	public String boardMasterPut(Map<String, Object> model) {
		BoardMaster boardMaster = new BoardMaster();
		model.put("boardMaster", boardMaster);
		model.put("sideMenu", "3");
		model.put("sideMenuSub", "3");
		return "boardMaster/boardMasterPut";
	}

	@RequestMapping(value = "/boardMaster/put", method = RequestMethod.POST)
	public String boardMasterPutPost(Map<String, Object> model, @Valid BoardMaster boardMaster, SessionStatus status) {
		logger.debug("]-------------]boardMasterPutPost[-------------[ {}", boardMaster);
		boardMasterService.putBoardMaster(boardMaster);
		status.setComplete();
		model.put("boardMaster", boardMaster);
		model.put("sideMenu", "3");
		model.put("sideMenuSub", "3");
		return "redirect:/boardMaster/list/1";
	}

	@RequestMapping(value = { "/boardMaster/{pageIndex}/{id}",
			"/boardMaster/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String boardMasterGet(Map<String, Object> model, BoardMaster boardMaster, @PathVariable int id,
			@PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables) {
		boardMaster.setId(id);
		BoardMaster boardMasterRes = boardMasterService.getBoardMaster(boardMaster);
		logger.debug("===========]boardMasterRes[=========== {}", boardMasterRes);
		model.put("boardMasterRes", boardMasterRes);

		model.put("sideMenu", "3");
		model.put("sideMenuSub", "3");
		return "boardMaster/boardMasterSet";
	}

	@RequestMapping(value = { "/boardMaster/set/{pageIndex}/{id}",
			"/boardMaster/set/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.POST)
	public String boardMasterSet(Map<String, Object> model, BoardMaster boardMaster, @PathVariable int id,
			HttpServletRequest req, @PathVariable int pageIndex, @PathVariable Map<String, String> pathVariables,
			SessionStatus status) throws Exception {
		logger.debug("========title======== {}", req.getParameter("title"));
		logger.debug("================ {}", boardMaster);
		String searchKey = pathVariables.get("searchKey");
		String searchVal = pathVariables.get("searchVal");
		boardMasterService.setBoardMaster(boardMaster);
		status.setComplete();
		boardMaster.setPageIndex(pageIndex);

		model.put("sideMenu", "3");
		model.put("sideMenuSub", "3");
		if (StringUtils.isNotEmpty(searchVal)) {
			boardMaster.setSearchKey(searchKey);
			boardMaster.setSearchVal(searchVal);
			model.put("boardMaster", boardMaster);
			return "redirect:/boardMaster/" + pageIndex + "/" + id + "/" + searchKey + "/" + searchVal;
		} else {
			model.put("boardMaster", boardMaster);
			//return "redirect:/boardMaster/" + pageIndex + "/" + id;
			return "redirect:/boardMaster/list/1";
		}
	}

}
