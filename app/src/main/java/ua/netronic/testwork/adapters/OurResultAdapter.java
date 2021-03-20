package ua.netronic.testwork.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ua.netronic.testwork.databinding.ItemUserListRecyclerBinding;
import ua.netronic.testwork.fragments.UserListFragment;
import ua.netronic.testwork.models.OurResult;

public class OurResultAdapter extends RecyclerView.Adapter<OurResultViewHolder> {

    private List<OurResult> items = new ArrayList<>();
    private UserListFragment fragment;

    public OurResultAdapter(UserListFragment fragment) {
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public OurResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemUserListRecyclerBinding binding = ItemUserListRecyclerBinding.inflate(inflater,parent,false);
        return  new OurResultViewHolder(binding,fragment);
    }

    public void  updateList(List<OurResult> results) {
        this.items= results;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull OurResultViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setNullListUserFragment() {
        fragment = null;
    }
}
