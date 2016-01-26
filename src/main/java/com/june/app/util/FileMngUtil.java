package com.june.app.util;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.june.app.model.Imgs;

/**
 * @Class Name : EgovFileMngUtil.java
 * @Description : 메시지 처리 관련 유틸리티
 * @Modification Information
 *
 *               수정일 수정자 수정내용 ------- -------- ---------------------------
 *               2009.02.13 이삼섭 최초 생성 2011.08.09 서준식 utl.fcc패키지와 Dependency제거를
 *               위해 getTimeStamp()메서드 추가
 * @author 공통 서비스 개발팀 이삼섭
 * @since 2009. 02. 13
 * @version 1.0
 * @see
 *
 */
@Component
public class FileMngUtil {

	protected static final Logger logger = LoggerFactory.getLogger(FileMngUtil.class);

	public static final int BUFF_SIZE = 2048;

	@Resource(name = "propUtil")
	public Properties properties;

	/**
	 * 웹에디터용 이미지 업로드 처리
	 *
	 * @param files
	 * @return
	 * @throws Exception
	 */
	public String parseFileInfSingle(MultipartFile file, String KeyStr, String storePath) throws Exception {

		String storePathString = "";
		String dateString;
		String dbPathString = "";
		Calendar cal = Calendar.getInstance();
		dateString = String.format("%04d-%02d-%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
				cal.get(Calendar.DAY_OF_MONTH));

		if ("".equals(storePath) || storePath == null) {
			storePathString = properties.getProperty("Globals.fileStorePath") + File.separator + dateString;
			dbPathString = properties.getProperty("default") + File.separator + dateString;

		} else {
			storePathString = properties.getProperty("Globals.fileStorePath") + properties.getProperty(storePath)
					+ File.separator + dateString;
			dbPathString = properties.getProperty(storePath) + File.separator + dateString;
		}

		File saveFolder = new File(storePathString);

		if (!saveFolder.exists() || saveFolder.isFile()) {
			saveFolder.mkdirs();
		}

		String filePath = "";

		String orginFileName = file.getOriginalFilename();
		int index = orginFileName.lastIndexOf(".");
		String fileExt = orginFileName.substring(index + 1);
		String newName = KeyStr + getTimeStamp() + "." + fileExt;

		if (!"".equals(orginFileName)) {
			filePath = storePathString + File.separator + newName;
			file.transferTo(new File(filePath));
		}

		String result = dbPathString + File.separator + newName;
		return result;
	}

	public String parseFileInfCompany(MultipartFile imgFile, String KeyStr, int fileKeyParam, String storePath)
			throws Exception {

		String storePathString = "";
		String dbPathString = "";
		if ("".equals(storePath) || storePath == null) {
			storePathString = properties.getProperty("Globals.fileStorePath");
			dbPathString = properties.getProperty("default");
		} else {
			storePathString = properties.getProperty("Globals.fileStorePath") + properties.getProperty(storePath);
			dbPathString = properties.getProperty(storePath);

		}

		File saveFolder = new File(EgovWebUtil.filePathBlackList(storePathString));

		if (!saveFolder.exists() || saveFolder.isFile()) {
			saveFolder.mkdirs();
		}
		String filePath = "";

		String fileExt = "";
		String newName = "";
		String orginFileName = "";

		if (!imgFile.isEmpty()) {
			orginFileName = imgFile.getOriginalFilename();

			int index = orginFileName.lastIndexOf(".");
			orginFileName.substring(0, index);
			fileExt = orginFileName.substring(index + 1);
			newName = KeyStr + getTimeStamp() + "." + fileExt;

			if (!"".equals(orginFileName)) {
				filePath = storePathString + File.separator + newName;
				imgFile.transferTo(new File(EgovWebUtil.filePathBlackList(filePath)));
			}
			return dbPathString + File.separator + newName;
		} else {
			return null;
		}

	}

	public List<Imgs> parseFileInfImgs(List<Imgs> imgs, String KeyStr, int fileKeyParam, String atchFileId,
			String storePath) throws Exception {
		int fileKey = fileKeyParam;

		String storePathString = "";
		String atchFileIdString = "";
		String dbPathString = "";
		if ("".equals(storePath) || storePath == null) {
			storePathString = properties.getProperty("Globals.fileStorePath");
			dbPathString = properties.getProperty("default");
		} else {
			storePathString = properties.getProperty("Globals.fileStorePath") + properties.getProperty(storePath);
			dbPathString = properties.getProperty(storePath);

		}

		File saveFolder = new File(EgovWebUtil.filePathBlackList(storePathString));

		if (!saveFolder.exists() || saveFolder.isFile()) {
			saveFolder.mkdirs();
		}
		MultipartFile file;
		String filePath = "";
		Iterator<Imgs> itr = imgs.iterator();

		// List<Imgs> result = new ArrayList<Imgs>();
		Imgs imgObj = null;
		String fileExt = "";
		String newName = "";
		String orginFileName = "";
		while (itr.hasNext()) {
			logger.debug("===========] call hasNext [=============");
			imgObj = itr.next();

			file = imgObj.getImgFile();
			if (!file.isEmpty()) {
				orginFileName = file.getOriginalFilename();

				int index = orginFileName.lastIndexOf("."); // String fileName =
				orginFileName.substring(0, index);
				fileExt = orginFileName.substring(index + 1);
				newName = KeyStr + getTimeStamp() + File.separator + fileExt;

				if (!"".equals(orginFileName)) {
					filePath = storePathString + File.separator + newName + File.separator + fileExt;
					file.transferTo(new File(EgovWebUtil.filePathBlackList(filePath)));
				}
			}

			imgObj.setExt(fileExt);
			imgObj.setoName(orginFileName);
			imgObj.setName(newName);
			imgObj.setFileuuid(atchFileIdString);
			imgObj.setUrl(dbPathString);

		}

		/*
		 * List<Imgs> result = new ArrayList<Imgs>(); for (Imgs imgObj : imgs) {
		 * file = imgObj.getImgFile(); if (!file.isEmpty()) {
		 * 
		 * String orginFileName = file.getOriginalFilename();
		 * 
		 * if ("".equals(orginFileName)) { continue; }
		 * 
		 * int index = orginFileName.lastIndexOf("."); // String fileName =
		 * orginFileName.substring(0, index); String fileExt =
		 * orginFileName.substring(index + 1); String newName = KeyStr +
		 * getTimeStamp(); long size = file.getSize();
		 * 
		 * if (!"".equals(orginFileName)) { filePath = storePathString +
		 * File.separator + newName; file.transferTo(new
		 * File(EgovWebUtil.filePathBlackList(filePath))); }
		 * 
		 * imgObj.setExt(fileExt); imgObj.setoName(orginFileName);
		 * imgObj.setName(newName); imgObj.setFileuuid(atchFileId);
		 * imgObj.setUrl(dbPathString);
		 * 
		 * result.add(imgObj); }
		 * 
		 * }
		 */

		return imgs;
	}

	/**
	 * 첨부파일에 대한 목록 정보를 취득한다.
	 *
	 * @param files
	 * @return
	 * @throws Exception
	 */
	public List<Imgs> parseFileInf(Map<String, MultipartFile> files, String KeyStr, int fileKeyParam, String atchFileId,
			String storePath) throws Exception {
		int fileKey = fileKeyParam;

		String storePathString = "";
		String atchFileIdString = "";

		if ("".equals(storePath) || storePath == null) {
			storePathString = properties.getProperty("Globals.fileStorePath");
		} else {
			storePathString = properties.getProperty(storePath);
		}
		if ("".equals(atchFileId) || atchFileId == null) {
			atchFileIdString = UUID.randomUUID().toString().replace("-", "");
		} else {
			atchFileIdString = atchFileId;
		}

		File saveFolder = new File(EgovWebUtil.filePathBlackList(storePathString));

		if (!saveFolder.exists() || saveFolder.isFile()) {
			saveFolder.mkdirs();
		}

		Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
		MultipartFile file;
		String filePath = "";
		List<Imgs> result = new ArrayList<Imgs>();
		Imgs fvo;

		while (itr.hasNext()) {
			logger.debug("===========] call hasNext [=============");
			Entry<String, MultipartFile> entry = itr.next();

			file = entry.getValue();
			String orginFileName = file.getOriginalFilename();

			// --------------------------------------
			// 원 파일명이 없는 경우 처리
			// (첨부가 되지 않은 input file type)
			// --------------------------------------
			if ("".equals(orginFileName)) {
				continue;
			}
			//// ------------------------------------

			int index = orginFileName.lastIndexOf(".");
			// String fileName = orginFileName.substring(0, index);
			String fileExt = orginFileName.substring(index + 1);
			String newName = KeyStr + getTimeStamp() + fileKey;
			long size = file.getSize();

			if (!"".equals(orginFileName)) {
				filePath = storePathString + File.separator + newName;
				file.transferTo(new File(EgovWebUtil.filePathBlackList(filePath)));
			}

			fvo = new Imgs();
			fvo.setExt(fileExt);
			fvo.setoName(orginFileName);
			fvo.setName(newName);
			fvo.setFileuuid(atchFileIdString);
			// fvo.setFileSn(String.valueOf(fileKey));

			result.add(fvo);

			fileKey++;
		}

		return result;
	}

	public List<Imgs> parseFileInf(List<MultipartFile> files, String KeyStr, int fileKeyParam, String atchFileId,
			String storePath) throws Exception {
		int fileKey = fileKeyParam;

		String storePathString = "";
		String atchFileIdString = "";
		String dbInsertPath = "";
		if ("".equals(storePath) || storePath == null) {
			storePathString = properties.getProperty("Globals.fileStorePath");
		} else {
			storePathString = properties.getProperty("Globals.fileStorePath") + properties.getProperty(storePath);
			dbInsertPath = properties.getProperty(storePath);
		}
		if ("".equals(atchFileId) || atchFileId == null) {
			atchFileIdString = UUID.randomUUID().toString().replace("-", "");
		} else {
			atchFileIdString = atchFileId;
		}

		File saveFolder = new File(EgovWebUtil.filePathBlackList(storePathString));

		if (!saveFolder.exists() || saveFolder.isFile()) {
			saveFolder.mkdirs();
		}

		Iterator<MultipartFile> itr = files.iterator();
		MultipartFile file;
		String filePath = "";
		List<Imgs> result = new ArrayList<Imgs>();
		Imgs fvo;

		while (itr.hasNext()) {
			logger.debug("===========] call hasNext [=============");
			MultipartFile entry = itr.next();

			file = entry;
			String orginFileName = file.getOriginalFilename();

			// --------------------------------------
			// 원 파일명이 없는 경우 처리
			// (첨부가 되지 않은 input file type)
			// --------------------------------------
			if ("".equals(orginFileName)) {
				continue;
			}
			//// ------------------------------------

			int index = orginFileName.lastIndexOf(".");
			// String fileName = orginFileName.substring(0, index);
			String fileExt = orginFileName.substring(index + 1);
			String newName = KeyStr + getTimeStamp() + fileKey + "." + fileExt;
			long size = file.getSize();

			if (!"".equals(orginFileName)) {
				filePath = storePathString + File.separator + newName;
				file.transferTo(new File(EgovWebUtil.filePathBlackList(filePath)));
			}

			BufferedImage bi = ImageIO.read(new File(EgovWebUtil.filePathBlackList(filePath)));
			// 일반적인 이미지 객체의 경우 getWidth메소드와 getHeight메소드가 틀립니다.
			// 파라미터가 있어 쓰기 곤란하므로 BufferedImage 로 쓰시는게 맞는것 같습니다.
			int xRes = bi.getWidth();
			int yRes = bi.getHeight();
			fvo = new Imgs();
			fvo.setExt(fileExt);
			fvo.setoName(orginFileName);
			fvo.setName(newName);
			fvo.setFileuuid(atchFileIdString);
			fvo.setUrl(dbInsertPath);
			fvo.setxRes(xRes + "");
			fvo.setyRes(yRes + "");
			// fvo.setFileSn(String.valueOf(fileKey));

			result.add(fvo);

			fileKey++;
		}

		return result;
	}

	/**
	 * 첨부파일을 서버에 저장한다.
	 *
	 * @param file
	 * @param newName
	 * @param stordFilePath
	 * @throws Exception
	 */
	protected void writeUploadedFile(MultipartFile file, String newName, String stordFilePath) throws Exception {
		InputStream stream = null;
		OutputStream bos = null;

		try {
			stream = file.getInputStream();
			File cFile = new File(stordFilePath);

			if (!cFile.isDirectory()) {
				boolean _flag = cFile.mkdir();
				if (!_flag) {
					throw new IOException("Directory creation Failed ");
				}
			}

			bos = new FileOutputStream(stordFilePath + File.separator + newName);

			int bytesRead = 0;
			byte[] buffer = new byte[BUFF_SIZE];

			while ((bytesRead = stream.read(buffer, 0, BUFF_SIZE)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}
		} finally {
			close(bos, stream);

		}
	}

	/**
	 * 서버의 파일을 다운로드한다.
	 *
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public static void downFile(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String downFileName = "";
		String orgFileName = "";

		if ((String) request.getAttribute("downFile") == null) {
			downFileName = "";
		} else {
			downFileName = (String) request.getAttribute("downFile");
		}

		if ((String) request.getAttribute("orgFileName") == null) {
			orgFileName = "";
		} else {
			orgFileName = (String) request.getAttribute("orginFile");
		}

		orgFileName = orgFileName.replaceAll("\r", "").replaceAll("\n", "");

		File file = new File(EgovWebUtil.filePathBlackList(downFileName));

		if (!file.exists()) {
			throw new FileNotFoundException(downFileName);
		}

		if (!file.isFile()) {
			throw new FileNotFoundException(downFileName);
		}

		byte[] buffer = new byte[BUFF_SIZE]; // buffer size 2K.

		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition:",
				"attachment; filename=" + new String(orgFileName.getBytes(), "UTF-8"));
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

		BufferedInputStream fin = null;
		BufferedOutputStream outs = null;

		try {
			fin = new BufferedInputStream(new FileInputStream(file));
			outs = new BufferedOutputStream(response.getOutputStream());
			int read = 0;

			while ((read = fin.read(buffer)) != -1) {
				outs.write(buffer, 0, read);
			}
		} finally {
			close(outs, fin);
		}
	}

	/**
	 * 첨부로 등록된 파일을 서버에 업로드한다.
	 *
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public HashMap<String, String> uploadFile(MultipartFile file) throws Exception {

		HashMap<String, String> map = new HashMap<String, String>();
		// Write File 이후 Move File????
		String newName = "";
		String stordFilePath = properties.getProperty("Globals.fileStorePath");
		String orginFileName = file.getOriginalFilename();

		int index = orginFileName.lastIndexOf(".");
		// String fileName = orginFileName.substring(0, _index);
		String fileExt = orginFileName.substring(index + 1);
		long size = file.getSize();

		// newName 은 Naming Convention에 의해서 생성
		newName = getTimeStamp(); // 2012.11 KISA 보안조치
		writeFile(file, newName, stordFilePath);
		// storedFilePath는 지정

		map.put("ORIGIN_FILE_NM", orginFileName);
		map.put("UPLOAD_FILE_NM", newName);
		map.put("FILE_EXT", fileExt);
		map.put("FILE_PATH", stordFilePath);
		map.put("FILE_SIZE", String.valueOf(size));

		return map;
	}

	public HashMap<String, String> uploadImage(MultipartFile file) throws Exception {

		HashMap<String, String> map = new HashMap<String, String>();
		// Write File 이후 Move File????
		String newName = "";
		String stordFilePath = properties.getProperty("Globals.fileStorePath") + properties.getProperty("Images");
		String orginFileName = file.getOriginalFilename();

		int index = orginFileName.lastIndexOf(".");
		// String fileName = orginFileName.substring(0, _index);
		String fileExt = orginFileName.substring(index + 1);
		long size = file.getSize();

		// newName 은 Naming Convention에 의해서 생성
		newName = getTimeStamp() + "." + fileExt; // 2012.11 KISA 보안조치
		writeFile(file, newName, stordFilePath);
		// storedFilePath는 지정

		String filePath = stordFilePath + File.separator + newName;
		BufferedImage bi = ImageIO.read(new File(EgovWebUtil.filePathBlackList(filePath)));
		// 일반적인 이미지 객체의 경우 getWidth메소드와 getHeight메소드가 틀립니다.
		// 파라미터가 있어 쓰기 곤란하므로 BufferedImage 로 쓰시는게 맞는것 같습니다.
		int xRes = bi.getWidth();
		int yRes = bi.getHeight();

		map.put("ORIGIN_FILE_NM", orginFileName);
		map.put("UPLOAD_FILE_NM", newName);
		map.put("FILE_EXT", fileExt);
		map.put("FILE_PATH", stordFilePath);
		map.put("FILE_SIZE", String.valueOf(size));
		map.put("filePath", properties.getProperty("Images") + File.separator + newName);
		map.put("xRes", xRes + "");
		map.put("yRes", yRes + "");
		return map;
	}

	/**
	 * 파일을 실제 물리적인 경로에 생성한다.
	 *
	 * @param file
	 * @param newName
	 * @param stordFilePath
	 * @throws Exception
	 */
	protected static void writeFile(MultipartFile file, String newName, String stordFilePath) throws Exception {
		InputStream stream = null;
		OutputStream bos = null;

		try {
			stream = file.getInputStream();
			File cFile = new File(EgovWebUtil.filePathBlackList(stordFilePath));

			if (!cFile.isDirectory())
				cFile.mkdir();

			bos = new FileOutputStream(EgovWebUtil.filePathBlackList(stordFilePath + File.separator + newName));

			int bytesRead = 0;
			byte[] buffer = new byte[BUFF_SIZE];

			while ((bytesRead = stream.read(buffer, 0, BUFF_SIZE)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}
		} finally {
			close(bos, stream);
		}
	}

	/**
	 * 서버 파일에 대하여 다운로드를 처리한다.
	 *
	 * @param response
	 * @param streFileNm
	 *            파일저장 경로가 포함된 형태
	 * @param orignFileNm
	 * @throws Exception
	 */
	public void downFile(HttpServletResponse response, String streFileNm, String orignFileNm) throws Exception {
		String downFileName = streFileNm;
		String orgFileName = orignFileNm;

		File file = new File(downFileName);

		if (!file.exists()) {
			throw new FileNotFoundException(downFileName);
		}

		if (!file.isFile()) {
			throw new FileNotFoundException(downFileName);
		}

		int fSize = (int) file.length();
		if (fSize > 0) {
			BufferedInputStream in = null;

			try {
				in = new BufferedInputStream(new FileInputStream(file));

				String mimetype = "application/x-msdownload";

				// response.setBufferSize(fSize);
				response.setContentType(mimetype);
				response.setHeader("Content-Disposition:", "attachment; filename=" + orgFileName);
				response.setContentLength(fSize);
				// response.setHeader("Content-Transfer-Encoding","binary");
				// response.setHeader("Pragma","no-cache");
				// response.setHeader("Expires","0");
				FileCopyUtils.copy(in, response.getOutputStream());
			} finally {
				close(in);
			}
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}

		/*
		 * String uploadPath = propertiesService.getString("fileDir");
		 * 
		 * File uFile = new File(uploadPath, requestedFile); int fSize = (int)
		 * uFile.length();
		 * 
		 * if (fSize > 0) { BufferedInputStream in = new BufferedInputStream(new
		 * FileInputStream(uFile));
		 * 
		 * String mimetype = "text/html";
		 * 
		 * //response.setBufferSize(fSize); response.setContentType(mimetype);
		 * response.setHeader("Content-Disposition", "attachment; filename=\"" +
		 * requestedFile + "\""); response.setContentLength(fSize);
		 * 
		 * FileCopyUtils.copy(in, response.getOutputStream()); in.close();
		 * response.getOutputStream().flush();
		 * response.getOutputStream().close(); } else {
		 * response.setContentType("text/html"); PrintWriter printwriter =
		 * response.getWriter(); printwriter.println("<html>");
		 * printwriter.println("<br><br><br><h2>Could not get file name:<br>" +
		 * requestedFile + "</h2>"); printwriter.println(
		 * "<br><br><br><center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>"
		 * ); printwriter.println("<br><br><br>&copy; webAccess");
		 * printwriter.println("</html>"); printwriter.flush();
		 * printwriter.close(); } //
		 */

		/*
		 * response.setContentType("application/x-msdownload");
		 * response.setHeader("Content-Disposition:", "attachment; filename=" +
		 * new String(orgFileName.getBytes(),"UTF-8" ));
		 * response.setHeader("Content-Transfer-Encoding","binary");
		 * response.setHeader("Pragma","no-cache");
		 * response.setHeader("Expires","0");
		 * 
		 * BufferedInputStream fin = new BufferedInputStream(new
		 * FileInputStream(file)); BufferedOutputStream outs = new
		 * BufferedOutputStream(response.getOutputStream()); int read = 0;
		 * 
		 * while ((read = fin.read(b)) != -1) { outs.write(b,0,read); }
		 * log.debug(this.getClass().getName()+
		 * " BufferedOutputStream Write Complete!!! ");
		 * 
		 * outs.close(); fin.close(); //
		 */
	}

	/**
	 * 공통 컴포넌트 utl.fcc 패키지와 Dependency제거를 위해 내부 메서드로 추가 정의함 응용어플리케이션에서 고유값을 사용하기
	 * 위해 시스템에서17자리의TIMESTAMP값을 구하는 기능
	 *
	 * @param
	 * @return Timestamp 값
	 * @see
	 */
	private static String getTimeStamp() {

		String rtnStr = null;

		// 문자열로 변환하기 위한 패턴 설정(년도-월-일 시:분:초:초(자정이후 초))
		String pattern = "yyyyMMddhhmmssSSS";

		SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
		Timestamp ts = new Timestamp(System.currentTimeMillis());

		rtnStr = sdfCurrent.format(ts.getTime());

		return rtnStr;
	}

	public static void close(Closeable... resources) {
		for (Closeable resource : resources) {
			if (resource != null) {
				try {
					resource.close();
				} catch (Exception ignore) {

				}
			}
		}
	}
}
