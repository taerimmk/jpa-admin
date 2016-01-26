
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

import com.june.app.model.Board;
import com.june.app.model.BoardMaster;
import com.june.app.model.Menu;
import com.june.app.service.BoardService;
import com.june.app.service.MenuService;

/**
 * @author Trk
 */
@Controller
public class BoardController extends CommonController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = { "/board/{board_master_id}/list/{pageIndex}",
			"/board/{board_master_id}/list/{pageIndex}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String boards(Map<String, Object> model, Board board, HttpServletRequest reques,
			@PathVariable("pageIndex") int pageIndex, @PathVariable("board_master_id") int board_master_id,
			@PathVariable Map<String, String> pathVariables, SessionStatus status) {

		/** 페이지당 보여주는 게시물 수 */
		board.setPageSize(10);
		/** 현재 페이지 */
		board.setPageIndex(pageIndex);
		/** 게시판 LIST */
		BoardMaster boardMaster = new BoardMaster();
		boardMaster.setId(board_master_id);
		// board.setBoardMst(boardMaster);
		board.setBoard_master_id(board_master_id);
		Collection<Board> boards = boardService.getBoardList(board);

		Collection<BoardMaster> boardMasterList = boardService.getBoardMasterListAll(boardMaster);
		int totalCnt = boardService.getBoardListCnt(board);
		board.setTotalCnt(totalCnt);

		model.put("boardMasterList", boardMasterList);
		model.put("boards", boards);
		model.put("sideMenu", "3");
		// model.put("sideMenuSub", "4");
		status.setComplete();
		return "board/boardList";
	}

	@RequestMapping(value = "/board/{board_master_id}/put", method = RequestMethod.GET)
	public String boardPut(Map<String, Object> model, @PathVariable("board_master_id") int board_master_id) {
		Board board = new Board();
		BoardMaster boardMaster = new BoardMaster();
		Collection<BoardMaster> boardMasterList = boardService.getBoardMasterListAll(boardMaster);

		logger.debug("========boardMasterList======== {}", boardMasterList);
		Menu menu = new Menu();
		Collection<Menu> menuList = menuService.getMenuListAll(menu);

		board.setBoard_master_id(board_master_id);
		model.put("menuList", menuList);
		model.put("boardMasterList", boardMasterList);
		model.put("board", board);
		model.put("sideMenu", "3");
		// model.put("sideMenuSub", "4");
		return "board/boardPut";
	}

	@RequestMapping(value = "/board/put", method = RequestMethod.POST)
	public String boardPutPost(Map<String, Object> model, @Valid Board board, SessionStatus status) {
		logger.debug("]-------------]boardPutPost[-------------[ {}", board);
		boardService.putBoard(board);
		status.setComplete();
		model.put("board", board);
		model.put("sideMenu", "3");
		// model.put("sideMenuSub", "4");
		return "redirect:/board/0/list/1";
	}

	@RequestMapping(value = { "/board/{board_master_id}/{pageIndex}/{id}",
			"/board/{board_master_id}/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String boardGet(Map<String, Object> model, Board board, @PathVariable int id, @PathVariable int pageIndex,
			@PathVariable("board_master_id") int board_master_id, @PathVariable Map<String, String> pathVariables) {
		logger.debug("===========]boardSetGet[=========== ");
		board.setId(id);
		BoardMaster boardMaster = new BoardMaster();
		boardMaster.setId(board_master_id);
		// board.setBoardMst(boardMaster);
		board.setBoard_master_id(board_master_id);
		Collection<BoardMaster> boardMasterList = boardService.getBoardMasterListAll(boardMaster);
		Board boardRes = boardService.getBoard(board);
		logger.debug("===========]boardRes[=========== {}", boardRes);

		Menu menu = new Menu();
		Collection<Menu> menuList = menuService.getMenuListAll(menu);
		logger.debug("===========]menuList[=========== {}", menuList);
		model.put("menuList", menuList);
		model.put("boardRes", boardRes);
		model.put("boardMasterList", boardMasterList);
		model.put("sideMenu", "3");
		// model.put("sideMenuSub", "4");
		return "board/boardSet";
	}

	@RequestMapping(value = { "/board/{board_master_id}/set/{pageIndex}/{id}",
			"/board/{board_master_id}/set/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.POST)
	public String boardSet(Map<String, Object> model, Board board, @PathVariable int id, HttpServletRequest req,
			@PathVariable int pageIndex, @PathVariable("board_master_id") int board_master_id,
			@PathVariable Map<String, String> pathVariables, SessionStatus status) throws Exception {
		logger.debug("========title======== {}", req.getParameter("title"));
		logger.debug("================ {}", board);
		String searchKey = pathVariables.get("searchKey");
		String searchVal = pathVariables.get("searchVal");
		//BoardMaster boardMaster = new BoardMaster();
		//boardMaster.setId(board_master_id);		
		//board.setBoard_master_id(board_master_id);
		//Collection<BoardMaster> boardMasterList = boardService.getBoardMasterListAll(boardMaster);
		//logger.debug("========boardMasterList======== {}", boardMasterList);
		boardService.setBoard(board);
		status.setComplete();
		board.setPageIndex(pageIndex);

		//model.put("boardMasterList", boardMasterList);
		model.put("sideMenu", "3");
		model.put("sideMenuSub", "4");
		if (StringUtils.isNotEmpty(searchVal)) {
			board.setSearchKey(searchKey);
			board.setSearchVal(searchVal);
			model.put("board", board);
			return "redirect:/board/" + board_master_id + "/" + pageIndex + "/" + id + "/" + searchKey + "/"
					+ searchVal;
		} else {
			model.put("board", board);
			return "redirect:/board/" + board_master_id + "/" + pageIndex + "/" + id;
		}

	}

	/*@RequestMapping(value = { "/board/del/{board_master_id}/{pageIndex}/{id}",
			"/board/del/{board_master_id}/{pageIndex}/{id}/{searchKey}/{searchVal}" }, method = RequestMethod.GET)
	public String boardDel(Map<String, Object> model, Board board, @PathVariable int id, @PathVariable int pageIndex,
			@PathVariable("board_master_id") int board_master_id, @PathVariable Map<String, String> pathVariables,
			SessionStatus status) {

		String searchKey = pathVariables.get("searchKey");
		String searchVal = pathVariables.get("searchVal");
		board.setId(id);
		boardService.delBoard(board);
		status.setComplete();
		board.setPageIndex(pageIndex);
		if (StringUtils.isNotEmpty(searchVal)) {
			board.setSearchKey(searchKey);
			board.setSearchVal(searchVal);
			model.put("board", board);
			return "redirect:/board/" + board_master_id + "/list/" + pageIndex + "/" + searchKey + "/" + searchVal;
		} else {
			model.put("board", board);
			return "redirect:/board/" + board_master_id + "/list/" + pageIndex;
		}
	}*/
}
