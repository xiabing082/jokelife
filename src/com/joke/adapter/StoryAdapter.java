/**
 * StoryAdapter.java
 * 版权所有(C) 2013 
 * 创建:cuiran 2013-7-15 上午11:30:23
 */
package com.joke.adapter;

import java.util.List;

import com.joke.R;
import com.joke.holder.JokeHolder;
import com.joke.net.dto.JokeInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * TODO
 * @author cuiran
 * @version TODO
 */
public class StoryAdapter extends BaseAdapter {

	private List<JokeInfo> data;
	private Context context = null;
	private LayoutInflater inflater = null;
	private JokeHolder holder;
	public StoryAdapter(List<JokeInfo> data, Context context) {
		super();
		this.data = data;
		this.context = context;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		inflater = LayoutInflater.from(this.context);
		if (convertView == null) {
			holder=new JokeHolder();
			convertView = inflater.inflate(R.layout.layout_story_item, null);
			
			holder.setSubject_tv((TextView)convertView.findViewById(R.id.subject_tv));
				
			
			convertView.setTag(holder);
		}else{
			holder=(JokeHolder)convertView.getTag();
		}
		JokeInfo info=data.get(position);
		holder.getSubject_tv().setText("• "+info.getSubject());
		
		
		return convertView;
	}
}
