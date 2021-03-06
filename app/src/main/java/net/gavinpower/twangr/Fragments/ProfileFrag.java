package net.gavinpower.twangr.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import static net.gavinpower.twangr.TwangR.HubConnection;
import static net.gavinpower.twangr.TwangR.currentUser;
import static net.gavinpower.twangr.TwangR.currentActivity;
import static net.gavinpower.twangr.TwangR.myPosts;

import net.gavinpower.Models.Status;
import net.gavinpower.Models.Statuses;
import net.gavinpower.Utilities.StatusListAdaptor;
import net.gavinpower.twangr.R;

public class ProfileFrag extends Fragment {

    private StatusListAdaptor adaptor;
    private ListView status;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        myPosts.getMyPosts();
        adaptor.notifyDataSetChanged();
    }

    public void populateMyPosts()
    {
        try {
            adaptor.notifyDataSetChanged();
        }
        catch(NullPointerException npe)
        {}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView RealName = (TextView) rootView.findViewById(R.id.profile_username);
        TextView NickName = (TextView) rootView.findViewById(R.id.profile_nickname);

        RealName.setText(currentUser.getUserRealName());
        NickName.setText("(" + currentUser.getUserNickName() + ")");

        status = (ListView)rootView.findViewById(R.id.myProfileStatus);
        adaptor = new StatusListAdaptor(currentActivity, myPosts);
        status.setAdapter(adaptor);
        return rootView;
    }
}
