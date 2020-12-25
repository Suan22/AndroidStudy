// Generated by view binder compiler. Do not edit!
package com.example.dec25_phonebookrecyclerview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.example.dec25_phonebookrecyclerview.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPhoneBookRecyclerBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final RecyclerView phoneBookRecyclerview;

  private ActivityPhoneBookRecyclerBinding(@NonNull LinearLayout rootView,
      @NonNull RecyclerView phoneBookRecyclerview) {
    this.rootView = rootView;
    this.phoneBookRecyclerview = phoneBookRecyclerview;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPhoneBookRecyclerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPhoneBookRecyclerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_phone_book_recycler, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPhoneBookRecyclerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.phone_book_recyclerview;
      RecyclerView phoneBookRecyclerview = rootView.findViewById(id);
      if (phoneBookRecyclerview == null) {
        break missingId;
      }

      return new ActivityPhoneBookRecyclerBinding((LinearLayout) rootView, phoneBookRecyclerview);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}