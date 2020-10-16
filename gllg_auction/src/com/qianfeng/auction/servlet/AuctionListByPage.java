package com.qianfeng.auction.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.auction.biz.AuctionBIZ;
import com.qianfeng.auction.dao.UserDAO;
import com.qianfeng.auction.util.PageVO;
import com.qianfeng.entity.Auction;
import com.qianfeng.entity.User;

// 为甚恶数据网格datagrid需要做分页
// 因为分页可以提高用户的体验
// 因为分页可以提高数据的查询速度
public class AuctionListByPage extends HttpServlet {

	UserDAO dao = new UserDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获取页的索引 如果没有获取到 那么默认就是第一页
		String pageindex = req.getParameter("pageindex") == null ? "1" : req
				.getParameter("pageindex");
		String pagenumber = req.getParameter("pagenumber") == null ? "10" : req
				.getParameter("pagenumber");
		// 获取总条数
		AuctionBIZ auctionBIZ = new AuctionBIZ();
		BigDecimal totalCount = auctionBIZ.getTotalCount();
		// 根据页码和条数 进行查询
		List<Auction> auctionList = auctionBIZ.findAuctionListByPage(
				new BigDecimal(pageindex), new BigDecimal(pagenumber));
		// 总条数和分页数据 都实例化之后 我们就可以实例化PAGEVO了
		PageVO<Auction> pageVO = new PageVO<Auction>();
		pageVO.setList(auctionList);
		pageVO.setPageIndex(new BigDecimal(pageindex));
		pageVO.setPageNumber(new BigDecimal(pagenumber));
		pageVO.setTotal(totalCount);
		// 假设我们有 11条数据 我们页要 分3页数据
		pageVO.setEndPage(totalCount.divide(new BigDecimal(pagenumber), 0,
				BigDecimal.ROUND_UP));
		// 把已經实例化好的 pageVO存储到请求报文中
		// setAttrubute和 ?pageIndex=xxxx 传输数据有何区别？
		// setAttrubute服务器行为产生的数据 一般使用这种方式 存储
		// ? 一般用户行为导致的数据 一般才使用这个 ?
		User user = (User) req.getSession().getAttribute("user");
		User userInfo = dao.findAllUserInfo(user);
		req.setAttribute("userInfo", userInfo);
		req.setAttribute("pageVO", pageVO);
		// 转发到auction_datagrid.jsp 这个文件
		req.getRequestDispatcher("auction_datagrid.jsp").forward(req, resp);
	}

}
