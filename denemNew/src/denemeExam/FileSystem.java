package denemeExam;

import java.util.ArrayList;

abstract class Entry{
	protected Directory parent;
	protected long created;
	protected long lastUpdated;
	protected long lastAccessed;
	protected String name;
	
	public Entry(String name ,Directory parent) {
		this.name = name;
		this.parent = parent;
		this.created = System.currentTimeMillis();
		this.lastAccessed = System.currentTimeMillis();
		this.lastAccessed = System.currentTimeMillis();
	}
	public boolean delete() {
		if(parent == null) return false;
		return parent.deleteEntry(this);
	}
	public abstract int size();
	public String getFullPath() {
		if(parent == null ) return name;
		else 
			return parent.getFullPath() + "/" + name;
	}	 
	public long getCreated() { return created; }	
	public long getLastUpdated() { return lastUpdated; }	
	public long getLastAccessed() { return lastAccessed; }	
	public String getName() { return name;}	
}

 class File extends Entry{
	private String content;
	private int size;
	public File(String name ,Directory d ,int size) {
		super(name, d);
		this.size = size; 
	}
	 
	public int size() { return size; }
 }
 class Directory extends Entry{
	protected ArrayList<Entry> contents;
	public Directory(String name ,Directory parent) {
		super(name ,parent);
		contents = new ArrayList<Entry>();
	}
	 
	public int size() {
		int size =0;
		for(Entry e: contents)
			size += e.size();
		return size;
	}
	
	public int numberOfFiles() {
		int count =0;
		for(Entry e:contents) {
			if( e instanceof Directory) {
				count++;
				Directory d = (Directory)e;
				count += d.numberOfFiles();
			}else if(e instanceof File)
				count++;
		}
		return count;
	}
	public boolean deleteEntry(Entry entry) {
		return contents.remove(entry);
	}
	public void addEntry(Entry entry) {
		contents.add(entry);
	}
}
public class FileSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
