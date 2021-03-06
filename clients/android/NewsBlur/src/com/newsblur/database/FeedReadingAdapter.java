package com.newsblur.database;

import android.support.v4.app.FragmentManager;

import com.newsblur.activity.ReadingAdapter;
import com.newsblur.domain.Classifier;
import com.newsblur.domain.Feed;
import com.newsblur.domain.Story;
import com.newsblur.fragment.ReadingItemFragment;

public class FeedReadingAdapter extends ReadingAdapter {

	private final Feed feed;
	private Classifier classifier;

	public FeedReadingAdapter(FragmentManager fm, Feed feed, Classifier classifier) {
        // sourceUserId not required for feed reading
		super(fm, null);
		this.feed = feed;
		this.classifier = classifier;
    }

	@Override
	protected synchronized ReadingItemFragment getReadingItemFragment(Story story) {
        return ReadingItemFragment.newInstance(story, feed.title, feed.faviconColor, feed.faviconFade, feed.faviconBorder, feed.faviconText, feed.faviconUrl, classifier, false, sourceUserId);
	}

}
