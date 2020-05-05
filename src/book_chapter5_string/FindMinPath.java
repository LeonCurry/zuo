package book_chapter5_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FindMinPath {
	public static HashMap<String, ArrayList<String>> getNexts(List<String> words){
		
		Set<String> dict = new HashSet<String>(words);
		HashMap<String, ArrayList<String>> nexts = new HashMap<String, ArrayList<String>>();
		for(int i = 0; i < words.size();i++) {
			nexts.put(words.get(i), new ArrayList<String>());
		}
		for(int i = 0 ; i < words.size(); i++) {
			nexts.put(words.get(i), getNext(words.get(i), dict));
		}
		return nexts;
	}
	public static ArrayList<String> getNext(String word, Set<String> dict){
		ArrayList<String> res = new ArrayList<String>();
		char[] chas = word.toCharArray();
		for(char cur = 'a' ; cur <= 'z' ; cur++) {
			for(int i = 0 ; i < chas.length;i++) {
				if(chas[i] != cur) {
					char temp = chas[i];
					chas[i] = cur;
					if(dict.contains(String.valueOf(chas))) {
						res.add(String.valueOf(chas));
					}
					chas[i] = temp;
				}
			}
		}
		return res;
	}
	public static HashMap<String,  Integer> getDistances(String start, HashMap<String, ArrayList<String >> nexts){
		HashMap<String, Integer> distances = new HashMap<String, Integer>();
		distances.put(start, 0);
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		Set<String> set = new HashSet<String>();
		set.add(start);
		while(!queue.isEmpty()) {
			String cur = queue.poll();
			for(String str : nexts.get(cur)) {
				if(!set.contains(str)) {
					distances.put(str, distances.get(cur) + 1);
					queue.add(str);
					set.add(str);
				}
			}
		}
		return distances;
	}
	public static void getShortestPaths(String cur, String to, HashMap<String, ArrayList<String>> nexts, HashMap<String, Integer> distances, LinkedList<String> solution, List<List<String>> res) {
		solution.add(cur);
		if(to.equals(cur)) {
			res.add(solution);
		}else {
			for(String next : nexts.get(cur)) {
				if(distances.get(next) == distances.get(cur) + 1) {
					getShortestPaths(next, to, nexts, distances, solution, res);
				}
			}
		}
		solution.pollLast();
	}
	public static List<List<String>> findMinPaths(String start, String to, List<String> list){
		list.add(start);
		HashMap<String, ArrayList<String>> nexts = getNexts(list);
		HashMap<String, Integer> distances = getDistances(start, nexts);
		LinkedList<String> solution = new LinkedList<String>();
		List<List<String>> res = new ArrayList<List<String>>();
		getShortestPaths(start, to, nexts, distances, solution, res);
		return res;
	}
}
