package javabogi.fileSearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A라는 디렉토리 하위에 있는 텍스트 파일(*.txt) 중에서 주어진 문자열을 포함하고 있는
 * 파일들을 모두 찾을 수 있는 프로그램을 작성하시오.
 *
 * 단, 하위 디렉토리도 포함해서 검색해야 함.
 *
 * ----------- Pseudocode ----------- 
 * TODO
 *
 */
public class FileSearch {

	public static void search(String keyword) {
		File folder = new File("src/javabogi/fileSearch/files");
		List<String> searchList = new ArrayList<String>();

		searchDirectory(folder, keyword, searchList);

		System.out.println("Find count of file.." + searchList.size());
		for (String file : searchList) {
			System.out.println(file);
		}
	}

	private static void searchDirectory(File target, String keyword, List<String> searchList) {
		if (target.isFile()) {
			if (searchFile(target, keyword)) {
				searchList.add(target.getAbsolutePath());
			}
			return;
		}

		File[] fileList = target.listFiles();
		if (fileList != null && fileList.length > 0) {
			for (File file : fileList) {
				searchDirectory(file, keyword, searchList);
			}
		}
	}

	private static boolean searchFile(File file, String keyword) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.contains(keyword)) {
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try { reader.close(); } catch (IOException e) {}
			}
		}
		return  false;
	}

	public static void main(String[] args) {
		FileSearch.search("is about a programming language");
	}

}
