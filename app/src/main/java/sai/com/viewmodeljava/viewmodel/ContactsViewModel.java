package sai.com.viewmodeljava.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.support.v7.widget.AppCompatImageView;

import com.squareup.picasso.Picasso;

import sai.com.viewmodeljava.R;
import sai.com.viewmodeljava.model.ContactsData;
import sai.com.viewmodeljava.utils.CircleTransform;

public class ContactsViewModel extends BaseObservable {

    private Context mContext;
    private ContactsData mContactsData;

    public ContactsViewModel(Context mContext, ContactsData mContactsData) {
        this.mContext = mContext;
        this.mContactsData = mContactsData;
    }

    @BindingAdapter({"profilePic"})
    public static void loadMyPic(AppCompatImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                //.transform(new CircleTransform())
                .placeholder(R.mipmap.ic_launcher)
                .into(view);
    }

    public void notifyContactsList(ContactsData data) {
        this.mContactsData = data;
        notifyChange();
    }

    public String getName() {
        return mContactsData.getName();
    }


    public String getProfilePic() {
        return mContactsData.getImage();
    }
}
